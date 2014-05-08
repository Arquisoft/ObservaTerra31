
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


Seq[Any](format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/navbarGuest/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""

	<h2>"""),_display_(Seq[Any](/*6.7*/Messages/*6.15*/.get("crawler"))),format.raw/*6.30*/("""</h2>
	

""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 08 09:19:28 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/crawler.scala.html
                    HASH: cff5b14427a299074397c23643797f8f486303dc
                    MATRIX: 884->30|921->33|940->44|979->46|1023->56|1039->64|1075->79
                    LINES: 30->3|31->4|31->4|31->4|33->6|33->6|33->6
                    -- GENERATED --
                */
            