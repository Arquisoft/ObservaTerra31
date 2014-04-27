
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages 


Seq[Any](format.raw/*1.20*/(""" 
"""),_display_(Seq[Any](/*3.2*/navbarGuest/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
"""),_display_(Seq[Any](/*4.2*/helper/*4.8*/.form(routes.Application.authenticate)/*4.46*/ {_display_(Seq[Any](format.raw/*4.48*/("""
<div class="col-xs-4 col-md-offset-4">
	<form class="form-signin" role="form">



		<h2 class="form-signin-heading">"""),_display_(Seq[Any](/*10.36*/Messages/*10.44*/.get("greetings"))),format.raw/*10.61*/("""</h2>
		<input type="email" class="form-control" value=""""),_display_(Seq[Any](/*11.52*/form("email")/*11.65*/.value)),format.raw/*11.71*/("""" placeholder=""""),_display_(Seq[Any](/*11.87*/Messages/*11.95*/.get(" email"))),format.raw/*11.109*/("""" required
			autofocus> <input type="password" class="form-control"
			placeholder=""""),_display_(Seq[Any](/*13.18*/Messages/*13.26*/.get(" password"))),format.raw/*13.43*/("""" required> <br>
			"""),_display_(Seq[Any](/*14.5*/if(form.hasGlobalErrors)/*14.29*/ {_display_(Seq[Any](format.raw/*14.31*/("""
					<p class="error">"""),_display_(Seq[Any](/*15.24*/form/*15.28*/.globalError.message)),format.raw/*15.48*/("""</p>
			""")))})),format.raw/*16.5*/("""
		<button class="btn btn-primary " type="submit">Sign in</button>
	</form>

</div>
""")))})),format.raw/*21.2*/(""" 
""")))})),format.raw/*22.2*/("""
"""))}
    }
    
    def render(form:Form[User]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[User]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 19:27:34 CEST 2014
                    SOURCE: /Users/Sergio/ObservaTerra31/ObservaTerra-Presentation/app/views/login.scala.html
                    HASH: a7eb8e7044828071ab3dab3b7eea7b4989d2313f
                    MATRIX: 778->1|917->19|954->50|973->61|1012->63|1048->65|1061->71|1107->109|1146->111|1300->229|1317->237|1356->254|1449->311|1471->324|1499->330|1551->346|1568->354|1605->368|1727->454|1744->462|1783->479|1839->500|1872->524|1912->526|1972->550|1985->554|2027->574|2067->583|2183->668|2217->671
                    LINES: 26->1|30->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|49->21|50->22
                    -- GENERATED --
                */
            