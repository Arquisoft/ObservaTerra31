
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
object navbarSnippet extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(userOptions: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.21*/(""" """),format.raw/*2.1*/("""
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">ObservaTerra</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href=""""),_display_(Seq[Any](/*20.19*/routes/*20.25*/.Application.index)),format.raw/*20.43*/("""">"""),_display_(Seq[Any](/*20.46*/Messages/*20.54*/.get("home"))),format.raw/*20.66*/("""</a></li>
				<li><a href=""""),_display_(Seq[Any](/*21.19*/routes/*21.25*/.Application.discover)),format.raw/*21.46*/("""">"""),_display_(Seq[Any](/*21.49*/Messages/*21.57*/.get("discover"))),format.raw/*21.73*/("""</a></li>
				<li><a href=""""),_display_(Seq[Any](/*22.19*/routes/*22.25*/.Application.organizations)),format.raw/*22.51*/("""">"""),_display_(Seq[Any](/*22.54*/Messages/*22.62*/.get("orgs"))),format.raw/*22.74*/("""</a></li>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">"""),_display_(Seq[Any](/*25.32*/Messages/*25.40*/.get("language"))),format.raw/*25.56*/(""" <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/idioma/es">"""),_display_(Seq[Any](/*27.35*/Messages/*27.43*/.get("es"))),format.raw/*27.53*/("""</a></li>
								<li><a href="/idioma/en">"""),_display_(Seq[Any](/*28.35*/Messages/*28.43*/.get("en"))),format.raw/*28.53*/("""</a></li>
							</ul>
							</li>
			</ul>
			<form class="navbar-form navbar-left" role="search" id="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						id="searchTextArea">
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">"""),_display_(Seq[Any](/*38.45*/userOptions)),format.raw/*38.56*/("""
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>"""))}
    }
    
    def render(userOptions:Html): play.api.templates.HtmlFormat.Appendable = apply(userOptions)
    
    def f:((Html) => play.api.templates.HtmlFormat.Appendable) = (userOptions) => apply(userOptions)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 08 19:28:47 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/navbarSnippet.scala.html
                    HASH: 84e7d76ac1aa9d6f3d10800c9ef756c5ee974fc8
                    MATRIX: 780->1|920->20|947->49|1748->814|1763->820|1803->838|1842->841|1859->849|1893->861|1958->890|1973->896|2016->917|2055->920|2072->928|2110->944|2175->973|2190->979|2238->1005|2277->1008|2294->1016|2328->1028|2474->1138|2491->1146|2529->1162|2662->1259|2679->1267|2711->1277|2792->1322|2809->1330|2841->1340|3188->1651|3221->1662
                    LINES: 26->1|30->1|30->2|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|53->25|53->25|53->25|55->27|55->27|55->27|56->28|56->28|56->28|66->38|66->38
                    -- GENERATED --
                */
            