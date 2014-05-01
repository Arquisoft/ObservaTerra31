
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
object organizations extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Organization],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(organizations: List[Organization]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.37*/(""" 
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/navbarGuest/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""

	<div class="list-group" id="organizations"><center>
	
	<h2>"""),_display_(Seq[Any](/*8.7*/Messages/*8.15*/.get("org"))),format.raw/*8.26*/("""</h2>
	"""),_display_(Seq[Any](/*9.3*/for(org <- organizations) yield /*9.28*/{_display_(Seq[Any](format.raw/*9.29*/("""
	<a href="#"
					class="list-group-item" 
					data-toggle="modal">
					<h5 class="list-group-item-heading">"""),_display_(Seq[Any](/*13.43*/org)),format.raw/*13.46*/("""</h5>
				</a> """)))})),format.raw/*14.11*/("""
	
	</center>
	</div>
	

""")))})))}
    }
    
    def render(organizations:List[Organization]): play.api.templates.HtmlFormat.Appendable = apply(organizations)
    
    def f:((List[Organization]) => play.api.templates.HtmlFormat.Appendable) = (organizations) => apply(organizations)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 01 17:48:53 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/organizations.scala.html
                    HASH: dc890d2d44e19a697191f560bc99f7ca6037f80f
                    MATRIX: 794->1|950->36|979->67|1016->70|1035->81|1074->83|1175->150|1191->158|1223->169|1266->178|1306->203|1344->204|1496->320|1521->323|1570->340
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|36->8|36->8|36->8|37->9|37->9|37->9|41->13|41->13|42->14
                    -- GENERATED --
                */
            