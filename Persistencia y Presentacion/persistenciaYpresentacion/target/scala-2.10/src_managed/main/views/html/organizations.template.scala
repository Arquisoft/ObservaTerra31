
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


Seq[Any](format.raw/*1.37*/(""" """),format.raw/*2.1*/("""
"""),_display_(Seq[Any](/*3.2*/navbarGuest/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
<div class="container-fluid">
	<div class="row">

		<div class="col-xs-12 col-md-3" id="DivVoid"></div>
		<div class="col-xs-12 col-md-9" id="orgs">

			<h2>"""),_display_(Seq[Any](/*10.9*/Messages/*10.17*/.get("org"))),format.raw/*10.28*/("""</h2>
			<p>"""),_display_(Seq[Any](/*11.8*/Messages/*11.16*/.get("orgsMsg"))),format.raw/*11.31*/("""</p>
			<div class="list-group" id="organizations">


				"""),_display_(Seq[Any](/*15.6*/for(org <- organizations) yield /*15.31*/{_display_(Seq[Any](format.raw/*15.32*/(""" <a href="#" class="list-group-item"
					data-toggle="modal">
					<h5 class="list-group-item-heading">"""),_display_(Seq[Any](/*17.43*/org)),format.raw/*17.46*/("""</h5>
				</a> """)))})),format.raw/*18.11*/("""

			</div>
		</div>
	</div>
</div>
""")))})),format.raw/*24.2*/("""
"""))}
    }
    
    def render(organizations:List[Organization]): play.api.templates.HtmlFormat.Appendable = apply(organizations)
    
    def f:((List[Organization]) => play.api.templates.HtmlFormat.Appendable) = (organizations) => apply(organizations)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun May 04 19:40:32 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/organizations.scala.html
                    HASH: 62a4a9fd71ba6546bba0af06cfe40313b1ab59b9
                    MATRIX: 794->1|949->36|976->64|1012->66|1031->77|1070->79|1264->238|1281->246|1314->257|1362->270|1379->278|1416->293|1510->352|1551->377|1590->378|1731->483|1756->486|1804->502|1872->539
                    LINES: 26->1|30->1|30->2|31->3|31->3|31->3|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15|43->15|45->17|45->17|46->18|52->24
                    -- GENERATED --
                */
            