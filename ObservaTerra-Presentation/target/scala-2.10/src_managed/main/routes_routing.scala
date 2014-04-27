// @SOURCE:/Users/Sergio/ObservaTerra31/ObservaTerra-Presentation/conf/routes
// @HASH:86ce79701c4f6a1e0ec832f90c2a644c3ee15977
// @DATE:Tue Apr 22 19:33:15 CEST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_idioma1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("idioma"))))
        

// @LINE:8
private[this] lazy val controllers_Application_login2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:9
private[this] lazy val controllers_Application_authenticate3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:10
private[this] lazy val controllers_Application_discover4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discover"))))
        

// @LINE:11
private[this] lazy val controllers_Application_organizations5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("organizations"))))
        

// @LINE:15
private[this] lazy val controllers_Assets_at6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:19
private[this] lazy val controllers_API_observationsByIndicator7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/observations/"),DynamicPart("indicator", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_API_ajax8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajaxE"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """idioma""","""controllers.Application.idioma()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discover""","""controllers.Application.discover()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """organizations""","""controllers.Application.organizations()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/observations/$indicator<[^/]+>""","""controllers.API.observationsByIndicator(indicator:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajaxE""","""controllers.API.ajax()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_idioma1(params) => {
   call { 
        invokeHandler(controllers.Application.idioma(), HandlerDef(this, "controllers.Application", "idioma", Nil,"GET", """""", Routes.prefix + """idioma"""))
   }
}
        

// @LINE:8
case controllers_Application_login2(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:9
case controllers_Application_authenticate3(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:10
case controllers_Application_discover4(params) => {
   call { 
        invokeHandler(controllers.Application.discover(), HandlerDef(this, "controllers.Application", "discover", Nil,"GET", """""", Routes.prefix + """discover"""))
   }
}
        

// @LINE:11
case controllers_Application_organizations5(params) => {
   call { 
        invokeHandler(controllers.Application.organizations(), HandlerDef(this, "controllers.Application", "organizations", Nil,"GET", """""", Routes.prefix + """organizations"""))
   }
}
        

// @LINE:15
case controllers_Assets_at6(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:19
case controllers_API_observationsByIndicator7(params) => {
   call(params.fromPath[String]("indicator", None)) { (indicator) =>
        invokeHandler(controllers.API.observationsByIndicator(indicator), HandlerDef(this, "controllers.API", "observationsByIndicator", Seq(classOf[String]),"GET", """ API""", Routes.prefix + """api/observations/$indicator<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_API_ajax8(params) => {
   call { 
        invokeHandler(controllers.API.ajax(), HandlerDef(this, "controllers.API", "ajax", Nil,"GET", """""", Routes.prefix + """ajaxE"""))
   }
}
        
}

}
     