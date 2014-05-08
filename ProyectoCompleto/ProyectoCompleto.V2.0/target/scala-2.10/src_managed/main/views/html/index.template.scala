
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Observation],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, observations: List[Observation]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.52*/(""" 
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/navbarGuest/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""

<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-md-3" id="divLeft"> 
		</div>
		<div class="col-xs-12 col-md-9" id="divMain">
			<h2>"""),_display_(Seq[Any](/*11.9*/Messages/*11.17*/.get("observations"))),format.raw/*11.37*/("""</h2>
			<br>
			<div class="list-group" id="observations">
				"""),_display_(Seq[Any](/*14.6*/for(observation <- observations) yield /*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/(""" 
				<a href="#"
					class="list-group-item" 
					data-toggle="modal"
					data-value=""""),_display_(Seq[Any](/*18.19*/observation/*18.30*/.getValue())),format.raw/*18.41*/(""""
					data-date=""""),_display_(Seq[Any](/*19.18*/observation/*19.29*/.getTime())),format.raw/*19.39*/(""""
					data-area=""""),_display_(Seq[Any](/*20.18*/observation/*20.29*/.getArea())),format.raw/*20.39*/(""""
					data-measure=""""),_display_(Seq[Any](/*21.21*/observation/*21.32*/.getMeasure())),format.raw/*21.45*/(""""
					data-provider=""""),_display_(Seq[Any](/*22.22*/observation/*22.33*/.getProvider())),format.raw/*22.47*/(""""
					data-indicator=""""),_display_(Seq[Any](/*23.23*/observation/*23.34*/.getIndicator())),format.raw/*23.49*/(""""
					data-publish=""""),_display_(Seq[Any](/*24.21*/observation/*24.32*/.getPublishDate())),format.raw/*24.49*/(""""
					data-id=""""),_display_(Seq[Any](/*25.16*/observation/*25.27*/.getId())),format.raw/*25.35*/("""">
					<h5 class="list-group-item-heading">"""),_display_(Seq[Any](/*26.43*/observation)),format.raw/*26.54*/("""</h5>
					<p class="list-group-item-text">
					<h6 class="text-right">"""),_display_(Seq[Any](/*28.30*/observation/*28.41*/.getPublishDate())),format.raw/*28.58*/("""</h6>
					</p>

				</a> """)))})),format.raw/*31.11*/("""
			</div>
		</div>
	</div>
	</div>


	""")))})))}
    }
    
    def render(message:String,observations:List[Observation]): play.api.templates.HtmlFormat.Appendable = apply(message,observations)
    
    def f:((String,List[Observation]) => play.api.templates.HtmlFormat.Appendable) = (message,observations) => apply(message,observations)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 08 09:19:28 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/index.scala.html
                    HASH: 8b8a8c3937e2671de3a2c2c861a22d32bb4c26fc
                    MATRIX: 792->1|963->51|992->82|1029->85|1048->96|1087->98|1294->270|1311->278|1353->298|1456->366|1504->398|1544->400|1675->495|1695->506|1728->517|1784->537|1804->548|1836->558|1892->578|1912->589|1944->599|2003->622|2023->633|2058->646|2118->670|2138->681|2174->695|2235->720|2255->731|2292->746|2351->769|2371->780|2410->797|2464->815|2484->826|2514->834|2596->880|2629->891|2740->966|2760->977|2799->994|2861->1024
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|39->11|39->11|39->11|42->14|42->14|42->14|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|56->28|56->28|56->28|59->31
                    -- GENERATED --
                */
            