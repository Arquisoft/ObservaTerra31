
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
object navbarLoggedUser extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages 


Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("ObservaTerra")/*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
	"""),_display_(Seq[Any](/*5.3*/navbarSnippet/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><i class="glyphicon glyphicon-upload"></i></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">"""),_display_(Seq[Any](/*9.32*/Messages/*9.40*/.get("account"))),format.raw/*9.55*/(""" <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">"""),_display_(Seq[Any](/*11.26*/Messages/*11.34*/.get("organizations"))),format.raw/*11.55*/("""</a></li>
								<li><a href="#">"""),_display_(Seq[Any](/*12.26*/Messages/*12.34*/.get("follows"))),format.raw/*12.49*/("""</a></li>
								<li><a href="#">"""),_display_(Seq[Any](/*13.26*/Messages/*13.34*/.get("settings"))),format.raw/*13.50*/("""</a></li>
								<li class="divider"></li>
								<li><a href="#">"""),_display_(Seq[Any](/*15.26*/Messages/*15.34*/.get("exit"))),format.raw/*15.46*/("""</a></li>
							</ul></li>
							
							
					</ul>
				""")))})),format.raw/*20.6*/("""
				
		<main> 
			"""),_display_(Seq[Any](/*23.5*/content)),format.raw/*23.12*/("""
		</main>

""")))})),format.raw/*26.2*/("""
"""))}
    }
    
    def render(content:Html): play.api.templates.HtmlFormat.Appendable = apply(content)
    
    def f:((Html) => play.api.templates.HtmlFormat.Appendable) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri May 09 18:41:44 CEST 2014
                    SOURCE: /Users/Sergio/Desktop/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/navbarLoggedUser.scala.html
                    HASH: 031ad128d440dc2d7dec5e895a5a8ce1bbf8897c
                    MATRIX: 783->1|920->16|948->47|985->50|1013->70|1052->72|1090->76|1111->89|1150->91|1404->310|1420->318|1456->333|1580->421|1597->429|1640->450|1712->486|1729->494|1766->509|1838->545|1855->553|1893->569|2000->640|2017->648|2051->660|2147->725|2205->748|2234->755|2281->771
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|43->15|48->20|51->23|51->23|54->26
                    -- GENERATED --
                */
            