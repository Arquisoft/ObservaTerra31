
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
                    DATE: Sat May 03 19:10:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/navbarSnippet.scala.html
                    HASH: 9ee8c6804d4908a0122f456004adfc86e9f20e25
                    MATRIX: 780->1|919->20|946->48|1729->795|1744->801|1784->819|1823->822|1840->830|1874->842|1938->870|1953->876|1996->897|2035->900|2052->908|2090->924|2154->952|2169->958|2217->984|2256->987|2273->995|2307->1007|2371->1035|2386->1041|2427->1060|2466->1063|2483->1071|2521->1087|2832->1362|2865->1373
                    LINES: 26->1|30->1|30->2|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|59->31|59->31
                    -- GENERATED --
                */
            