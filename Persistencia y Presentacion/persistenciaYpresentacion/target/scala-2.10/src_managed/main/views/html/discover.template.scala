
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
object discover extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*2.2*/navbarGuest/*2.13*/ {_display_(Seq[Any](format.raw/*2.15*/("""

	<p>P�gina de descubre</p>

""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 03 19:10:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/discover.scala.html
                    HASH: 3b5b0d2327e6b8d8386a7806d2ca7684f136fa30
                    MATRIX: 867->2|886->13|925->15
                    LINES: 29->2|29->2|29->2
                    -- GENERATED --
                */
            