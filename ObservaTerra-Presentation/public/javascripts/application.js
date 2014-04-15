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
				d3.selectAll(".progress").remove();
				d3.selectAll(".progress-bar progress-bar-danger").remove();
				
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
				.attr("aria-valuenow", function(d) { return d; })
				.text(function(d) { return d; });

				$(".progress-bar").each(
						function() {
							$(this).attr(
									"style",
									"width: " + $(this).attr("aria-valuenow")
											+ "%");
						});

			}
			
	   /**
		* Función que añade el componente contenedor de las gráficas.
		*/
			function appendChartDiv() {
				var divChart = $('<h2>Chart</h2>'
						+ '<br />' + '<div class="panel panel-default">'
						+ '<div class="panel-heading">'
						+ '<h3 class="panel-title">Chart</h3>' + '</div>'
						+ '<div class="panel-body" id="chart"></div>'
						+ '</div>');

				$("#divChart").append(divChart);
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

						if ($(this).attr("class") == "list-group-item active") {
							// Borrar dato
							var i = data.indexOf($(this).attr("data-value"));
							if (i != -1)
								data.splice(i, 1);
							// Borar highlight
							$(this).removeClass("list-group-item active")
									.addClass("list-group-item");
							// draw();
							drawBarsBootstraps();
							if (data.length == 0)
								$("#divChart").children().remove();

						}

						else {
							if (data.length == 0)
								appendChartDiv();
							// Añadir dato
							
							data.push($(this).attr("data-value"));
							// Añadir highlight
							$(this).addClass("list-group-item active");
							// draw();
							drawBarsBootstraps();
						}
					});

		});