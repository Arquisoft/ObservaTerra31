
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
object idioma extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.19*/(""" 
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/navbarLoggedUser/*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""

			<div class="sel">
				<select>
  					<option value="es">"""),_display_(Seq[Any](/*8.28*/Messages/*8.36*/.get("spa"))),format.raw/*8.47*/("""</option>
  					<option value="en">"""),_display_(Seq[Any](/*9.28*/Messages/*9.36*/.get("en"))),format.raw/*9.46*/("""</option>
				</select>
  
			</div>



	""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 19 12:54:31 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/ObservaTerra-Presentation/app/views/idioma.scala.html
                    HASH: 9cef8960cbad556de73f0e63366ec9ec23b5368f
                    MATRIX: 775->1|912->18|940->47|976->49|1000->65|1039->67|1137->130|1153->138|1185->149|1257->186|1273->194|1304->204
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|36->8|36->8|36->8|37->9|37->9|37->9
                    -- GENERATED --
                */
            