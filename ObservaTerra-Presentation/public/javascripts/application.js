$(document).ready(function () {
	
	var data = []
	
	function draw() {
		d3.selectAll(".bar").remove();
		
		alert("realshit " + data);
		alert(d3.select("#chart"))
		d3.select("#chart")
		.selectAll(".panel-body")
		.data(data)
		.enter()
		.append("div")
		.attr("class", "bar")
		.style("height", function(d) {
			var barHeight = d * 5;
			return barHeight + "px";
		});
	}
	
	
	
	$("#observations").find(".list-group-item").on('click', function() {

		if($(this).attr("class") == "list-group-item active"){
			//Borrar dato
			var i = data.indexOf($(this).attr("data-value"));
			if(i != -1) 
				data.splice(i, 1);
			//Borar highlight
			$(this).removeClass("list-group-item active").addClass("list-group-item");
			draw();
		}
		
		else {
			//Añadir dato
			data.push($(this).attr("data-value"));
			//Añadir highlight
			$(this).addClass("list-group-item active");
			draw();
		}
	});
	
	
	
	
});