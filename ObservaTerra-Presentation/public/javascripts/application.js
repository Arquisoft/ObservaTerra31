
$(document).ready(
		function() {
			
		// Array usado para almacenar temporalmente los datos
			var data = []
				
			
/**
			
			***********************************************************
			***********************************************************
			***														***
			***														***
			***						FUNCIONES						***
			***														***
			***														***
			***********************************************************
			***********************************************************
			
			*/
			
		/**
		 * Función que dibuja barras simples.
		 */
			function draw() {
				
				d3.selectAll(".bar").remove();

				d3.select("#chart").selectAll(".panel-body").data(data).enter()
						.append("div").attr("class", "bar").style("height",
								function(d) {
									var barHeight = d * 5;
									return barHeight + "px";
								});
			}
			
			
			function addData(element) {
				console.log("Entra en addData");
				var data2 = [].concat(data);
				if(!compatibleValues(element, data[0]))
					clearData(data2);
				data2.push(element);
				console.log(data2);
				element.addClass("list-group-item active");
				return data;
			}
			
			function deleteData(element) {
				var index;
				for (var i = 0; i < data.length; i++)
					if(data[i].attr("data-id") == element.attr("data-id"))
						index = i;
				
				
				if (index != -1)
					data.splice(index, 1);
				element.removeClass("list-group-item active")
					   .addClass("list-group-item");
				if (data.length == 0)
					$("#divLeft").children().remove();
				return data;
			}
			
			function clearData() {
				data = [];
				var x = $(".list-group-item active");
				$(".list-group-item").removeClass("list-group-item active")
				   .addClass("list-group-item");
				return data;
			}
			
			function compatibleValues(element, head) {
				if (head == null) {
					appendChartDiv();
					return true;
				}
				else {
					var newMeasure = element.attr("data-measure");
					var oldMeasure = head.attr("data-measure");
					return newMeasure == "%" && oldMeasure == "%"
						||  newMeasure != "%" && oldMeasure != "%";
				}
			}
			
			
			function actionClick(element) {
				if (element.attr("class") == "list-group-item active")
					deleteData(element);
				else
					addData(element);
				
				drawBarsBootstraps();
			}
			
			
			
			
			
		/**
		 * Función que dibuja barras estilo bootstraps.
		 */
			function drawBarsBootstraps() {
				
				var values = data.map (function(d) { return d.attr("data-value").valueOf();});
				maxValue = values.reduce (function(previous,current) { 
                    return previous > current ? 
                    		previous
                    		: current;
                });
				

				d3.selectAll(".progress").remove();
				d3.selectAll(".progress-bar-danger").remove();
				
				
				d3.select("#chart")
				.selectAll(".panel-body")
				.data(data)
				.enter()
				.append("div")
				.attr("class", "progress progress-striped active")
				.append("div")
				.attr("role", "progressbar")
				.attr("animation", "true")
				.attr("class","progress-bar progress-bar-danger")
				.attr("aria-valuemin", "0")
				.attr("aria-valuemax", "100")
				.attr("data-content", function(d) { var x = d.children("h5").text(); return x; })
				.attr("data-trigger", "click")
				.attr("aria-valuenow", function(d) { return d.attr("data-value"); })
				.text(function(d) { return d.attr("data-value") + (((x = d.attr("data-measure")).lenght) != 1 ? " "+ x: x)});

				$(".progress-bar").each(
						function() {
							$(this).attr(
									"style",
									"width: " + widthValue($(this).attr("aria-valuenow"), maxValue)
											+ "%");
						});
				
				
				 $('.progress-bar').popover({
				        content: $(this).attr("data-content"),
				        trigger: 'hover',
				        animation: 'true',
				        delay: '500',
				        placement: 'bottom'
				       
				    });

			}
			
			
			function widthValue (elementValue, maxValue) {
				return maxValue <= 100 ? elementValue : (elementValue/maxValue) * 100;
			}
			
			
			
			function observationRequest(indicator) {
				$("#observations").children(".list-group-item").remove();
				$.ajax({
					url : "/api/observations/sida",
					dataType : 'json',
					success : function(data) {
						for (var i in data)
							for (var x in i) {
								var obj = data[i][x].valueOf();
								console.log(obj);
								var ind = obj.indicator;
								//var ind = indicator;
								var value = obj.value;
								var measure = obj.measure;
								var area = obj.area;
								var provider = obj.provider;
								var publishDate = obj.publishDate;
								var time = obj.time;
								var id = obj.id;
								
								var item = ind + " " + "at" + " " + time
								+ " in " + " " + area + " " + " was "
								+ " " + value + (measure.length == 1 ? "" : " ") + measure
								+ " " + "by" + provider + ".";
								
								
								var taghead = "<a href=\"#\" class=\"list-group-item\" data-toggle=\"modal\" data-value=\"" + value +
									"\" data-indicator=\""+ ind + "\" data-measure=\""+ measure + "\" data-area=\"" + area + "\" data-provider=\"" + provider + "\" data-publish=\"" + publishDate +
									"\" data-date=\"" + time + "\" data-id=\""+ id + "\">"
								
								var body = "<h5 class=\"list-group-item-heading\">" + item + "</h5>";
								var footer = "<p class=\"list-group-item-text\"> <h6 class=\"text-right\">" + publishDate + "</h6> </p></a>";
								
								$("#observations").append(taghead +body + footer);
								$("#observations").children().last().addClass("list-group-item");
								
								$("#observations").delegate("a", "click", function() {
									actionClick($(this));
								});
								
								
								
							}
							

					}
				});
				
				
			}
			
	   /**
		* Función que añade el componente contenedor de las gráficas.
		*/
			function appendChartDiv() {
				var divChart =  '<h2>Chart</h2><br><div class="panel panel-success" id="divChart">'
						+ '<div class="panel-heading">'
						+ '<h3 class="panel-title">Chart</h3>' + '</div>'
						+ '<div class="panel-body" id="chart"></div>'
						+ '</div>';
				

				$("#divLeft").append(divChart);
			}
			
			/**
			
			***********************************************************
			***********************************************************
			***														***
			***														***
			***						EVENTOS							***
			***														***
			***														***
			***********************************************************
			***********************************************************
			
			*/
			

			$("#searchTextArea").keyup(function(event){
				if(event.keyCode == 13) {
					observationRequest("sida");
				}
			});
	
			

			$(".list-group-item").on(
					'click', function() {
						actionClick($(this));
					});
					

		});