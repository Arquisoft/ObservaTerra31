
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
			autofocus name="emailLog"> <input type="password" class="form-control"
			placeholder=""""),_display_(Seq[Any](/*13.18*/Messages/*13.26*/.get(" password"))),format.raw/*13.43*/("""" required name="passLog"> <br>
			"""),_display_(Seq[Any](/*14.5*/if(form.hasGlobalErrors)/*14.29*/ {_display_(Seq[Any](format.raw/*14.31*/("""
					<p class="error">"""),_display_(Seq[Any](/*15.24*/form/*15.28*/.globalError.message)),format.raw/*15.48*/("""</p>
			""")))})),format.raw/*16.5*/("""
		<button class="btn btn-primary " type="submit">"""),_display_(Seq[Any](/*17.51*/Messages/*17.59*/.get("sign"))),format.raw/*17.71*/("""</button>
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
                    DATE: Fri May 09 18:41:44 CEST 2014
                    SOURCE: /Users/Sergio/Desktop/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/app/views/login.scala.html
                    HASH: a4c5c34ebc0067a89e4a4ef55551375b14f3efd7
                    MATRIX: 778->1|918->19|956->52|975->63|1014->65|1051->68|1064->74|1110->112|1149->114|1309->238|1326->246|1365->263|1459->321|1481->334|1509->340|1561->356|1578->364|1615->378|1755->482|1772->490|1811->507|1883->544|1916->568|1956->570|2017->595|2030->599|2072->619|2113->629|2201->681|2218->689|2252->701|2315->733|2350->737
                    LINES: 26->1|30->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|45->17|45->17|45->17|49->21|50->22
                    -- GENERATED --
                */
            