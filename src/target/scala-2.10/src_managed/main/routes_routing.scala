// @SOURCE:/Users/Sergio/Desktop/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/conf/routes
// @HASH:10e60fc85343f8db9947f3fc5ec3b066dbc74964
// @DATE:Fri May 09 18:41:43 CEST 2014


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
private[this] lazy val controllers_Application_page1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("page/"),DynamicPart("page", """[^/]+""",true))))
        

// @LINE:8
private[this] lazy val controllers_Application_idioma2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("idioma/"),DynamicPart("codigo", """[^/]+""",true))))
        

// @LINE:9
private[this] lazy val controllers_Application_login3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:10
private[this] lazy val controllers_Application_authenticate4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Application_discover5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discover"))))
        

// @LINE:12
private[this] lazy val controllers_Application_organizations6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("organizations"))))
        

// @LINE:13
private[this] lazy val controllers_Application_register7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registro"))))
        

// @LINE:14
private[this] lazy val controllers_Application_registerAut8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registro"))))
        

// @LINE:15
private[this] lazy val controllers_API_crawler9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("crawler"))))
        

// @LINE:18
private[this] lazy val controllers_Assets_at10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:22
private[this] lazy val controllers_API_observationsByIndicator11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/observations/"),DynamicPart("indicator", """[^/]+""",true))))
        

// @LINE:23
private[this] lazy val controllers_API_followsByIDUser12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/follows/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:24
private[this] lazy val controllers_API_ajax13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajaxE"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """page/$page<[^/]+>""","""controllers.Application.page(page:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """idioma/$codigo<[^/]+>""","""controllers.Application.idioma(codigo:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discover""","""controllers.Application.discover()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """organizations""","""controllers.Application.organizations()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registro""","""controllers.Application.register()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registro""","""controllers.Application.registerAut()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """crawler""","""controllers.API.crawler()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/observations/$indicator<[^/]+>""","""controllers.API.observationsByIndicator(indicator:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/follows/$id<[^/]+>""","""controllers.API.followsByIDUser(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajaxE""","""controllers.API.ajax()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_Application_page1(params) => {
   call(params.fromPath[Integer]("page", None)) { (page) =>
        invokeHandler(controllers.Application.page(page), HandlerDef(this, "controllers.Application", "page", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """page/$page<[^/]+>"""))
   }
}
        

// @LINE:8
case controllers_Application_idioma2(params) => {
   call(params.fromPath[String]("codigo", None)) { (codigo) =>
        invokeHandler(controllers.Application.idioma(codigo), HandlerDef(this, "controllers.Application", "idioma", Seq(classOf[String]),"GET", """""", Routes.prefix + """idioma/$codigo<[^/]+>"""))
   }
}
        

// @LINE:9
case controllers_Application_login3(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:10
case controllers_Application_authenticate4(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Application_discover5(params) => {
   call { 
        invokeHandler(controllers.Application.discover(), HandlerDef(this, "controllers.Application", "discover", Nil,"GET", """""", Routes.prefix + """discover"""))
   }
}
        

// @LINE:12
case controllers_Application_organizations6(params) => {
   call { 
        invokeHandler(controllers.Application.organizations(), HandlerDef(this, "controllers.Application", "organizations", Nil,"GET", """""", Routes.prefix + """organizations"""))
   }
}
        

// @LINE:13
case controllers_Application_register7(params) => {
   call { 
        invokeHandler(controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Nil,"GET", """""", Routes.prefix + """registro"""))
   }
}
        

// @LINE:14
case controllers_Application_registerAut8(params) => {
   call { 
        invokeHandler(controllers.Application.registerAut(), HandlerDef(this, "controllers.Application", "registerAut", Nil,"POST", """""", Routes.prefix + """registro"""))
   }
}
        

// @LINE:15
case controllers_API_crawler9(params) => {
   call { 
        invokeHandler(controllers.API.crawler(), HandlerDef(this, "controllers.API", "crawler", Nil,"GET", """""", Routes.prefix + """crawler"""))
   }
}
        

// @LINE:18
case controllers_Assets_at10(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:22
case controllers_API_observationsByIndicator11(params) => {
   call(params.fromPath[String]("indicator", None)) { (indicator) =>
        invokeHandler(controllers.API.observationsByIndicator(indicator), HandlerDef(this, "controllers.API", "observationsByIndicator", Seq(classOf[String]),"GET", """ API""", Routes.prefix + """api/observations/$indicator<[^/]+>"""))
   }
}
        

// @LINE:23
case controllers_API_followsByIDUser12(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.API.followsByIDUser(id), HandlerDef(this, "controllers.API", "followsByIDUser", Seq(classOf[Long]),"GET", """""", Routes.prefix + """api/follows/$id<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_API_ajax13(params) => {
   call { 
        invokeHandler(controllers.API.ajax(), HandlerDef(this, "controllers.API", "ajax", Nil,"GET", """""", Routes.prefix + """ajaxE"""))
   }
}
        
}

}
     