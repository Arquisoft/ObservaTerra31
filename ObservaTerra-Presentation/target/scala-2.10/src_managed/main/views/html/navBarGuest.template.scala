
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
object navbarGuest extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages 


Seq[Any](format.raw/*1.17*/(""" 
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("ObservaTerra")/*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
	"""),_display_(Seq[Any](/*5.3*/navbarSnippet/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">"""),_display_(Seq[Any](/*7.21*/Messages/*7.29*/.get("log"))),format.raw/*7.40*/("""</a></li>
			<li><a href="#">"""),_display_(Seq[Any](/*8.21*/Messages/*8.29*/.get("register"))),format.raw/*8.45*/("""</a></li>
			
		</ul>
""")))})),format.raw/*11.2*/("""

<main> 
	"""),_display_(Seq[Any](/*14.3*/content)),format.raw/*14.10*/(""" 
</main>

""")))})),format.raw/*17.2*/("""
"""))}
    }
    
    def render(content:Html): play.api.templates.HtmlFormat.Appendable = apply(content)
    
    def f:((Html) => play.api.templates.HtmlFormat.Appendable) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 18:00:19 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/ObservaTerra-Presentation/app/views/navbarGuest.scala.html
                    HASH: 1e7fc4c85f746f759e36ea0a59dd5edb13d97c0c
                    MATRIX: 778->1|914->16|942->46|978->48|1006->68|1045->70|1082->73|1103->86|1142->88|1241->152|1257->160|1289->171|1354->201|1370->209|1407->225|1461->248|1508->260|1537->267|1580->279
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|39->11|42->14|42->14|45->17
                    -- GENERATED --
                */
            