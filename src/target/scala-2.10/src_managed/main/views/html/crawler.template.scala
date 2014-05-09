
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
object crawler extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages

import java.util.Date


Seq[Any](format.raw/*3.1*/("""
<script type="text/javascript">
	<!-- reload cada 24 horas -->
	window.setTimeout(
			function()"""),format.raw/*7.14*/("""{"""),format.raw/*7.15*/("""window.location.href=window.location.href"""),format.raw/*7.56*/("""}"""),format.raw/*7.57*/(""",
			86400000);
</script>

"""),_display_(Seq[Any](/*11.2*/navbarGuest/*11.13*/ {_display_(Seq[Any](format.raw/*11.15*/("""
	<p>
		<center>
		"""),_display_(Seq[Any](/*14.4*/{new Date().format("dd MMMM yyyy hh:mm:ss")})),format.raw/*14.48*/("""
		"""),_display_(Seq[Any](/*15.4*/Messages/*15.12*/.get("crawler"))),format.raw/*15.27*/("""
		</center>
	</p>
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri May 09 18:41:43 CEST 2014
                    SOURCE: /Users/Sergio/Desktop/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/crawler.scala.html
                    HASH: ab5e90d8ffed38731393c192b4efa9a0f3a0f517
                    MATRIX: 908->52|1036->153|1064->154|1132->195|1160->196|1227->228|1247->239|1287->241|1345->264|1411->308|1451->313|1468->321|1505->336
                    LINES: 32->3|36->7|36->7|36->7|36->7|40->11|40->11|40->11|43->14|43->14|44->15|44->15|44->15
                    -- GENERATED --
                */
            