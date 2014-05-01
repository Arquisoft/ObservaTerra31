
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
				<li><a href=""""),_display_(Seq[Any](/*23.19*/routes/*23.25*/.Application.idioma)),format.raw/*23.44*/("""">"""),_display_(Seq[Any](/*23.47*/Messages/*23.55*/.get("language"))),format.raw/*23.71*/("""</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search" id="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						id="searchTextArea">
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">"""),_display_(Seq[Any](/*31.45*/userOptions)),format.raw/*31.56*/("""
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
                    DATE: Thu May 01 17:27:17 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/navbarSnippet.scala.html
                    HASH: d72f1c9b1ed981d163db9217860e855b9e7dd3e5
                    MATRIX: 780->1|920->20|947->49|1748->814|1763->820|1803->838|1842->841|1859->849|1893->861|1958->890|1973->896|2016->917|2055->920|2072->928|2110->944|2175->973|2190->979|2238->1005|2277->1008|2294->1016|2328->1028|2393->1057|2408->1063|2449->1082|2488->1085|2505->1093|2543->1109|2862->1392|2895->1403
                    LINES: 26->1|30->1|30->2|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|59->31|59->31
                    -- GENERATED --
                */
            