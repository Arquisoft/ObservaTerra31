
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
object registro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages 


Seq[Any](format.raw/*1.20*/(""" 
"""),_display_(Seq[Any](/*3.2*/navbarGuest/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
"""),_display_(Seq[Any](/*4.2*/helper/*4.8*/.form(routes.Application.registerAut)/*4.45*/ {_display_(Seq[Any](format.raw/*4.47*/("""
<div class="col-xs-4 col-md-offset-4">
	<form class="form-register" role="form">
		<h2 class="form-register-heading">"""),_display_(Seq[Any](/*7.38*/Messages/*7.46*/.get("regist"))),format.raw/*7.60*/("""</h2>
			<input type="text" class="form-control" placeholder=""""),_display_(Seq[Any](/*8.58*/Messages/*8.66*/.get("name"))),format.raw/*8.78*/("""" required autofocus name="nameReg">
			<input type="text" class="form-control" placeholder=""""),_display_(Seq[Any](/*9.58*/Messages/*9.66*/.get("surname"))),format.raw/*9.81*/("""" required autofocus name="surnameReg">
			<input type="email" class="form-control" placeholder=""""),_display_(Seq[Any](/*10.59*/Messages/*10.67*/.get("email"))),format.raw/*10.80*/("""" required autofocus name="emailReg">
			<input type="password" class="form-control"	placeholder=""""),_display_(Seq[Any](/*11.62*/Messages/*11.70*/.get("password"))),format.raw/*11.86*/("""" required name="passReg"> <br>
			"""),_display_(Seq[Any](/*12.5*/if(form.hasGlobalErrors)/*12.29*/ {_display_(Seq[Any](format.raw/*12.31*/("""
					<p class="error">"""),_display_(Seq[Any](/*13.24*/form/*13.28*/.globalError.message)),format.raw/*13.48*/("""</p>
			""")))})),format.raw/*14.5*/("""
		<button class="btn btn-primary " type="submit">Sign in</button>
	</form>

</div>
""")))})),format.raw/*19.2*/("""
""")))})),format.raw/*20.2*/("""

"""))}
    }
    
    def render(form:Form[User]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[User]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 03 19:10:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/app/views/registro.scala.html
                    HASH: 89c0c57a60090208951276f7f50a85d47f5f9936
                    MATRIX: 781->1|920->19|957->50|976->61|1015->63|1051->65|1064->71|1109->108|1148->110|1302->229|1318->237|1353->251|1451->314|1467->322|1500->334|1629->428|1645->436|1681->451|1815->549|1832->557|1867->570|2002->669|2019->677|2057->693|2128->729|2161->753|2201->755|2261->779|2274->783|2316->803|2356->812|2472->897|2505->899
                    LINES: 26->1|30->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|47->19|48->20
                    -- GENERATED --
                */
            