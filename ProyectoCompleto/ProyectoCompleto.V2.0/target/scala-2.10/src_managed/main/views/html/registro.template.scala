
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
                    DATE: Thu May 08 09:19:29 CEST 2014
                    SOURCE: C:/Users/Lara/Documents/GitHub/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/registro.scala.html
                    HASH: 31137ba4d9ef084f4415c2cd830178300e6714c4
                    MATRIX: 781->1|921->19|959->52|978->63|1017->65|1054->68|1067->74|1112->111|1151->113|1308->235|1324->243|1359->257|1458->321|1474->329|1507->341|1637->436|1653->444|1689->459|1824->558|1841->566|1876->579|2012->679|2029->687|2067->703|2139->740|2172->764|2212->766|2273->791|2286->795|2328->815|2369->825|2490->915|2524->918
                    LINES: 26->1|30->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|47->19|48->20
                    -- GENERATED --
                */
            