
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
			<li><a href="/login">"""),_display_(Seq[Any](/*7.26*/Messages/*7.34*/.get("log"))),format.raw/*7.45*/("""</a></li>
			<li><a href="/registro">"""),_display_(Seq[Any](/*8.29*/Messages/*8.37*/.get("register"))),format.raw/*8.53*/("""</a></li>			
		</ul>
""")))})),format.raw/*10.2*/("""

<main> 
	"""),_display_(Seq[Any](/*13.3*/content)),format.raw/*13.10*/(""" 
</main>

""")))})),format.raw/*16.2*/("""
"""))}
    }
    
    def render(content:Html): play.api.templates.HtmlFormat.Appendable = apply(content)
    
    def f:((Html) => play.api.templates.HtmlFormat.Appendable) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 03 19:10:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/navbarGuest.scala.html
                    HASH: 0942a4277320a99465d980f267afa0fec2d3ddaf
                    MATRIX: 778->1|914->16|942->46|978->48|1006->68|1045->70|1082->73|1103->86|1142->88|1246->157|1262->165|1294->176|1367->214|1383->222|1420->238|1473->260|1520->272|1549->279|1592->291
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|38->10|41->13|41->13|44->16
                    -- GENERATED --
                */
            