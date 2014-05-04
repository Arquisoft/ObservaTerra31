
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
object navbarLoggedUser extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages 


Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("ObservaTerra")/*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
	"""),_display_(Seq[Any](/*5.3*/navbarSnippet/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><i class="glyphicon glyphicon-upload"></i></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">"""),_display_(Seq[Any](/*9.32*/Messages/*9.40*/.get("account"))),format.raw/*9.55*/(""" <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">"""),_display_(Seq[Any](/*11.26*/Messages/*11.34*/.get("organizations"))),format.raw/*11.55*/("""</a></li>
								<li><a href="#">"""),_display_(Seq[Any](/*12.26*/Messages/*12.34*/.get("follows"))),format.raw/*12.49*/("""</a></li>
								<li><a href="#">"""),_display_(Seq[Any](/*13.26*/Messages/*13.34*/.get("settings"))),format.raw/*13.50*/("""</a></li>
								<li><a href=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Application.idioma)),format.raw/*14.48*/("""">"""),_display_(Seq[Any](/*14.51*/Messages/*14.59*/.get("language"))),format.raw/*14.75*/("""</a></li>
								<li class="divider"></li>
								<li><a href="#">"""),_display_(Seq[Any](/*16.26*/Messages/*16.34*/.get("exit"))),format.raw/*16.46*/("""</a></li>
							</ul></li>
							
					</ul>
				""")))})),format.raw/*20.6*/("""
				
		<main> 
			"""),_display_(Seq[Any](/*23.5*/content)),format.raw/*23.12*/("""
		</main>

""")))})),format.raw/*26.2*/("""
"""))}
    }
    
    def render(content:Html): play.api.templates.HtmlFormat.Appendable = apply(content)
    
    def f:((Html) => play.api.templates.HtmlFormat.Appendable) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 03 19:10:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/navbarLoggedUser.scala.html
                    HASH: a8bd89edb3b9728bec1a81001be379d15cc740b4
                    MATRIX: 783->1|919->16|946->45|982->47|1010->67|1049->69|1086->72|1107->85|1146->87|1396->302|1412->310|1448->325|1570->411|1587->419|1630->440|1701->475|1718->483|1755->498|1826->533|1843->541|1881->557|1949->589|1964->595|2005->614|2044->617|2061->625|2099->641|2204->710|2221->718|2255->730|2338->782|2393->802|2422->809|2466->822
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|44->16|44->16|44->16|48->20|51->23|51->23|54->26
                    -- GENERATED --
                */
            