
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
				.attr("class", "progress")
				.append("div")
				.attr("role", "progressbar")
				.attr("class","progress-bar progress-bar-danger")
				.attr("aria-valuemin", "0")
				.attr("aria-valuemax", "100")
				.attr("aria-valuenow", function(d) { return d.attr("data-value"); })
				.text(function(d) { return d.attr("data-value") + (((x = d.attr("data-measure")).lenght) != 1 ? " "+ x: x); });

				$(".progress-bar").each(
						function() {
							$(this).attr(
									"style",
									"width: " + widthValue($(this).attr("aria-valuenow"), maxValue)
											+ "%");
						});

			}
			
			
			function widthValue (elementValue, maxValue) {
				return maxValue <= 100 ? elementValue : (elementValue/maxValue) * 100;
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
			

			$("#observations").find(".list-group-item").on(
					'click', function() {
						
						function addData(element) {
							if(!compatibleValues(element, data[0]))
								clearData();
							data.push(element);
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
						
						
						if ($(this).attr("class") == "list-group-item active")
							deleteData($(this));
						else
							addData($(this));
						
						drawBarsBootstraps();
					});
					

		});