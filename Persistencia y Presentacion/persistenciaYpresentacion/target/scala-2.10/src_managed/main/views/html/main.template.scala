
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Lang,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html)(implicit l:Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n._


Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.1*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*9.17*/title)),format.raw/*9.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*10.103*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*13.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/application.js"))),format.raw/*14.69*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/d3.min.js"))),format.raw/*15.64*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/waypoints.min.js"))),format.raw/*16.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/waypoints-sticky.min.js"))),format.raw/*17.78*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("javascripts/search.js"))),format.raw/*18.64*/("""" type="text/javascript"></script>
        <style type="text/css">
		
			div.bar """),format.raw/*21.12*/("""{"""),format.raw/*21.13*/("""
				display: inline-block;
				width: 20px;
				height: 75px;	/* Gets overriden by D3-assigned height below */
				margin-right: 2px;
				background-color: teal;
			"""),format.raw/*27.4*/("""}"""),format.raw/*27.5*/("""
		
		</style>
    </head>
    <body>
        """),_display_(Seq[Any](/*32.10*/content)),format.raw/*32.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html,l:Lang): play.api.templates.HtmlFormat.Appendable = apply(title)(content)(l)
    
    def f:((String) => (Html) => (Lang) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => (l) => apply(title)(content)(l)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 03 19:10:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/main.scala.html
                    HASH: 10e6f445a7ecafbc9bb3b7dded32828a42889bd3
                    MATRIX: 783->1|943->48|970->69|1058->122|1084->127|1182->189|1197->195|1263->238|1360->299|1375->305|1429->337|1490->362|1505->368|1572->413|1665->470|1680->476|1744->518|1837->575|1852->581|1914->621|2007->678|2022->684|2079->719|2172->776|2187->782|2251->824|2344->881|2359->887|2430->936|2523->993|2538->999|2595->1034|2704->1115|2733->1116|2926->1282|2954->1283|3037->1330|3066->1337
                    LINES: 26->1|30->1|31->3|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|55->27|55->27|60->32|60->32
                    -- GENERATED --
                */
            