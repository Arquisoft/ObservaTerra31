
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object ajaxE extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*2.1*/("""
<html>
<head>
<title>AJAX</title>
<script src=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*6.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Assets.at("javascripts/search.js"))),format.raw/*7.56*/("""" type="text/javascript"></script>
<script type="text/javascript">
function observationRequest(indicator) """),format.raw/*9.40*/("""{"""),format.raw/*9.41*/("""
	
	$.ajax("""),format.raw/*11.9*/("""{"""),format.raw/*11.10*/("""
		url : "/api/observations/sida",
		dataType : 'json',
		success : function(data) """),format.raw/*14.28*/("""{"""),format.raw/*14.29*/("""
			for (var i in data)
				for (var x in i) """),format.raw/*16.22*/("""{"""),format.raw/*16.23*/("""
					
					var indicator = data[i][x].indicator;
					var value = data[i][x].value;
					var measure = data[i][x].measure;
					var area = data[i][x].area;
					var provider = data[i][x].provider;
					var publishDate = data[i][x].publishDate;
					var time = data[i][x].time;
					var id = data[i][x].id;
					
					var item = indicator + " " + "at" + " " + time
					+ " in " + " " + area + " " + " was "
					+ " " + value + (measure.length == 1 ? "" : " ") + measure
					+ " " + "by" + provider + ".";
					
					console.log(item);
					
					var taghead = "<a href=\"#\" class=\"list-group-item\" data-toggle=\"modal\" data-value=\"" + value +
					"\" data-measure=\""+ measure + "\" data-area=\"" + area + "\" data-provider=\"" + provider + "\" data-publish=\"" + publishDate +
					"\" data-time=\"" + time + "\ data-id=\""+ id + "\">"
					
					console.log(taghead);
					var body = "<h5 class=\"list-group-item-heading\">" + item + "</h5>";
					
					console.log(body);
					var footer = "<p class=\"list-group-item-text\"> <h6 class=\"text-right\">" + publishDate + "</h6> </p></a>";
					console.log(footer);
					
					$(".insert").append(taghead +body + footer);
					
				"""),format.raw/*47.5*/("""}"""),format.raw/*47.6*/("""
				

		"""),format.raw/*50.3*/("""}"""),format.raw/*50.4*/("""
	"""),format.raw/*51.2*/("""}"""),format.raw/*51.3*/(""");
"""),format.raw/*52.1*/("""}"""),format.raw/*52.2*/("""

</script>

</head>
<body>
	
	<input type="button" value="AJAX" onclick="observationRequest('sida')" />
	<div class="insert">
		<ul class="list">
		</ul>
	</div>
</body>
</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 01 17:27:16 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/ajaxE.scala.html
                    HASH: 06f0e80aeed16aba0ad908213067d119c147e52f
                    MATRIX: 882->28|970->81|984->87|1050->132|1135->182|1149->188|1205->223|1340->331|1368->332|1408->345|1437->346|1551->432|1580->433|1655->480|1684->481|2933->1703|2961->1704|3000->1716|3028->1717|3058->1720|3086->1721|3117->1725|3145->1726
                    LINES: 30->2|34->6|34->6|34->6|35->7|35->7|35->7|37->9|37->9|39->11|39->11|42->14|42->14|44->16|44->16|75->47|75->47|78->50|78->50|79->51|79->51|80->52|80->52
                    -- GENERATED --
                */
            