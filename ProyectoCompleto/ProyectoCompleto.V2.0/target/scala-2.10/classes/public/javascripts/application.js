
$(document).ready(
		function() {
			
				
			
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
				var measure = $("#observations").children(".active").data("measure");
				if(!compatibleValues(element, measure))
					clearData();
				element.addClass("list-group-item active");
			}
			
			function deleteData(element) {
				element.removeClass("list-group-item active")
					   .addClass("list-group-item");
				var active= $("#observations").children(".active");
				if (active.length == 0)
					$("#divLeft").children().remove();
			}
			
			function clearData() {
				$(".list-group-item").removeClass("list-group-item active")
				   .addClass("list-group-item");
			}
			
			function compatibleValues(element, head) {
				if (head == null) {
					appendChartDiv();
					return true;
				}
				else {
					
					var newMeasure = element.attr("data-measure");
					var oldMeasure = head;
					return newMeasure == "%" && oldMeasure == "%"
						||  newMeasure != "%" && oldMeasure != "%";
				}
			}
			
			
			function actionClick(element) {
				var isThereActiveElements = $("#observations").children(".active").length;
				if (element.attr("class") == "list-group-item active" && isThereActiveElements)
					deleteData(element);
				else
					addData(element);
				drawBarsBootstraps();
				
			}
			
			function getElementsFromBars () {
				var ids = $(".progress").map (function(d) { return d.attr("data-id").valueOf();});
				var elements = $("#divMain").children().filter(function() {
					return ids.contains($(this).attr("data-id").valueOf());
				});
				return elements;
			}
			
			
		function getMaxValue(collection) {
				var maxValue = -1;
				for (var i = 0 ; i < collection.length; i++)
					if(collection[i] > maxValue)
						maxValue = collection[i];
				return maxValue;
			}
		
		function removeProgressBar() {
			d3.selectAll(".progress").remove();
			d3.selectAll(".progress-bar-danger").remove();
		}
			
			
		/**
		 * Función que dibuja barras estilo bootstraps.
		 */
			function drawBarsBootstraps() {
				var array = $("#observations").children(".active");
				var elements = array.map (function() {return $(this).valueOf(); });
				var values = array.map (function() { return parseInt($(this).data("value")); });
				
				var maxValue = getMaxValue(values);
				removeProgressBar();
		
				
				
				for (var i = 0 ; i < elements.length; i++) {
					var x;
					$("#chart").append("<div class=\"progress progress-striped active\"> </div>");
					var progressBar = "<div role=\progressbar\" class=\"progress-bar progress-bar-danger\" aria-valuemin=\"0 \" aria-valuemax=\"100\" "
										+ "data-id=\"" + elements[i].data("id") 
										+ "\" data-content=\"" + elements[i].children("h5").text() 
										+ "\" aria-valuenow=\"" + values[i]
										+ "\" style=\"width: " + widthValue(values[i], parseInt(maxValue)) + "%"
										+ "\" >" 
										+ values[i]+ "  " + ((x = elements[i].data("measure")).lenght > 1 ? " " + x : x )
										+ "</div>"
										
					$("#chart").children().last().append(progressBar);
					
				}
					
				
			
				
				 $('.progress-bar').popover({
				        content: $(this).attr("data-content"),
				        trigger: 'hover',
				        animation: 'true',
				        delay: '500',
				        placement: 'bottom'
				       
				    });

			}
			
			
			function widthValue (elementValue, maxValue) {
				//return maxValue <= 100 ? elementValue : (elementValue/maxValue) * 100;
				return (elementValue/maxValue) * 100;
			}
			
			
			
			function observationRequest(indicator) {
				$("#observations").children(".active").removeClass();
				$("#observations").children().remove();
				$("#divLeft").children().remove();;
				$.ajax({
					url : "/api/observations/"+indicator,
					dataType : 'json',
					success : function(data) {
						for (var i in data)
							for (var x in i) {
								var obj = data[i][x].valueOf();
								
								var ind = obj.indicator;
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
								$("#observations").undelegate();
								
								$("#observations").delegate(".list-group-item", "click", function() {
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
			

			$(".list-group-item").on(
					'click', function() {
						actionClick($(this));
					});
			
			$("#search").submit(function (event) {
				
				var keyword = $("#searchTextArea").val();
				 event.preventDefault();
				 if (keyword.trim().length != 0)
					 observationRequest(keyword);
			});		
			

	$('a[href="' + this.location.pathname + '"]').parent().addClass('active');
	

		});
		