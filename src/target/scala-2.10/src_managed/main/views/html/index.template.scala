
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,List[Observation],Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, observations: List[Observation], paginaCoger: Integer ):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.75*/(""" 
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
			
      	
         <ul class="pagination" id="pageF">
         
  							<li><a href="""),_display_(Seq[Any](/*36.23*/{var xx= "/page/" + (paginaCoger-1); xx;})),format.raw/*36.64*/(""">&laquo;</a></li>
  							
 							<li><a href="""),_display_(Seq[Any](/*38.22*/{var xx= "/page/" + (paginaCoger+1); xx;})),format.raw/*38.63*/(""">"""),_display_(Seq[Any](/*38.65*/(paginaCoger+1))),format.raw/*38.80*/("""</a></li>
  							<li><a href="""),_display_(Seq[Any](/*39.23*/{var xx= "/page/" + (paginaCoger+2); xx;})),format.raw/*39.64*/(""">"""),_display_(Seq[Any](/*39.66*/(paginaCoger+2))),format.raw/*39.81*/("""</a></li>
 							<li><a href="""),_display_(Seq[Any](/*40.22*/{var xx= "/page/" + (paginaCoger+3); xx;})),format.raw/*40.63*/(""">"""),_display_(Seq[Any](/*40.65*/(paginaCoger+3))),format.raw/*40.80*/("""</a></li>
  							<li><a href="""),_display_(Seq[Any](/*41.23*/{var xx= "/page/" + (paginaCoger+4); xx;})),format.raw/*41.64*/(""">"""),_display_(Seq[Any](/*41.66*/(paginaCoger+4))),format.raw/*41.81*/("""</a></li>
  							<li><a href="""),_display_(Seq[Any](/*42.23*/{var xx= "/page/" + (paginaCoger+5); xx;})),format.raw/*42.64*/(""">"""),_display_(Seq[Any](/*42.66*/(paginaCoger+5))),format.raw/*42.81*/("""</a></li>
 							<li><a href="""),_display_(Seq[Any](/*43.22*/{var xx= "/page/" + (paginaCoger+6); xx;})),format.raw/*43.63*/(""">&raquo;</a></li>
					</ul>
      
				
					
			</div>
			
		</div>
	</div>

	</div>


	""")))})))}
    }
    
    def render(message:String,observations:List[Observation],paginaCoger:Integer): play.api.templates.HtmlFormat.Appendable = apply(message,observations,paginaCoger)
    
    def f:((String,List[Observation],Integer) => play.api.templates.HtmlFormat.Appendable) = (message,observations,paginaCoger) => apply(message,observations,paginaCoger)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri May 09 18:41:44 CEST 2014
                    SOURCE: /Users/Sergio/Desktop/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/index.scala.html
                    HASH: 1e2656c04a5eff3e68338ccd49bf30bfbc5905d3
                    MATRIX: 800->1|994->74|1023->105|1060->108|1079->119|1118->121|1325->293|1342->301|1384->321|1487->389|1535->421|1575->423|1706->518|1726->529|1759->540|1815->560|1835->571|1867->581|1923->601|1943->612|1975->622|2034->645|2054->656|2089->669|2149->693|2169->704|2205->718|2266->743|2286->754|2323->769|2382->792|2402->803|2441->820|2495->838|2515->849|2545->857|2627->903|2660->914|2771->989|2791->1000|2830->1017|2892->1047|3022->1141|3085->1182|3172->1233|3235->1274|3273->1276|3310->1291|3379->1324|3442->1365|3480->1367|3517->1382|3585->1414|3648->1455|3686->1457|3723->1472|3792->1505|3855->1546|3893->1548|3930->1563|3999->1596|4062->1637|4100->1639|4137->1654|4205->1686|4268->1727
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|39->11|39->11|39->11|42->14|42->14|42->14|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|56->28|56->28|56->28|59->31|64->36|64->36|66->38|66->38|66->38|66->38|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43
                    -- GENERATED --
                */
            