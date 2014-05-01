// @SOURCE:C:/Users/Lara/Documents/GitHub/ObservaTerra31/Persistencia y Presentacion/persistenciaYpresentacion/conf/routes
// @HASH:02493f703a00b42aff8422696024dbb10bc1ffcf
// @DATE:Thu May 01 17:27:14 CEST 2014


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
        

// @LINE:12
private[this] lazy val controllers_Application_register6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registro"))))
        

// @LINE:13
private[this] lazy val controllers_Application_registerAut7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registro"))))
        

// @LINE:17
private[this] lazy val controllers_Assets_at8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:21
private[this] lazy val controllers_API_observationsByIndicator9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/observations/"),DynamicPart("indicator", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_API_followsByIDUser10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/follows/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:23
private[this] lazy val controllers_API_ajax11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajaxE"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """idioma""","""controllers.Application.idioma()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discover""","""controllers.Application.discover()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """organizations""","""controllers.Application.organizations()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registro""","""controllers.Application.register()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registro""","""controllers.Application.registerAut()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/observations/$indicator<[^/]+>""","""controllers.API.observationsByIndicator(indicator:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/follows/$id<[^/]+>""","""controllers.API.followsByIDUser(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajaxE""","""controllers.API.ajax()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:12
case controllers_Application_register6(params) => {
   call { 
        invokeHandler(controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Nil,"GET", """""", Routes.prefix + """registro"""))
   }
}
        

// @LINE:13
case controllers_Application_registerAut7(params) => {
   call { 
        invokeHandler(controllers.Application.registerAut(), HandlerDef(this, "controllers.Application", "registerAut", Nil,"POST", """""", Routes.prefix + """registro"""))
   }
}
        

// @LINE:17
case controllers_Assets_at8(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:21
case controllers_API_observationsByIndicator9(params) => {
   call(params.fromPath[String]("indicator", None)) { (indicator) =>
        invokeHandler(controllers.API.observationsByIndicator(indicator), HandlerDef(this, "controllers.API", "observationsByIndicator", Seq(classOf[String]),"GET", """ API""", Routes.prefix + """api/observations/$indicator<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_API_followsByIDUser10(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.API.followsByIDUser(id), HandlerDef(this, "controllers.API", "followsByIDUser", Seq(classOf[Long]),"GET", """""", Routes.prefix + """api/follows/$id<[^/]+>"""))
   }
}
        

// @LINE:23
case controllers_API_ajax11(params) => {
   call { 
        invokeHandler(controllers.API.ajax(), HandlerDef(this, "controllers.API", "ajax", Nil,"GET", """""", Routes.prefix + """ajaxE"""))
   }
}
        
}

}
     