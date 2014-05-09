
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
""")))})))}
    }
    
    def render(organizations:List[Organization]): play.api.templates.HtmlFormat.Appendable = apply(organizations)
    
    def f:((List[Organization]) => play.api.templates.HtmlFormat.Appendable) = (organizations) => apply(organizations)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri May 09 18:41:44 CEST 2014
                    SOURCE: /Users/Sergio/Desktop/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/organizations.scala.html
                    HASH: dc597bf4b7f39dbd6197dbf3d4238f8c81ea20a8
                    MATRIX: 794->1|950->36|977->65|1014->68|1033->79|1072->81|1273->247|1290->255|1323->266|1372->280|1389->288|1426->303|1524->366|1565->391|1604->392|1747->499|1772->502|1821->519
                    LINES: 26->1|30->1|30->2|31->3|31->3|31->3|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15|43->15|45->17|45->17|46->18
                    -- GENERATED --
                */
            