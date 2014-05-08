// @SOURCE:C:/Users/Lara/Documents/GitHub/ObservaTerra31/ProyectoCompleto/ProyectoCompleto.V2.0/conf/routes
// @HASH:10e60fc85343f8db9947f3fc5ec3b066dbc74964
// @DATE:Thu May 08 17:27:59 CEST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:15
class ReverseAPI {
    

// @LINE:23
def followsByIDUser(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/follows/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:15
def crawler(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "crawler")
}
                                                

// @LINE:24
def ajax(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ajaxE")
}
                                                

// @LINE:22
def observationsByIndicator(indicator:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/observations/" + implicitly[PathBindable[String]].unbind("indicator", dynamicString(indicator)))
}
                                                
    
}
                          

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:14
def registerAut(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registro")
}
                                                

// @LINE:12
def organizations(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "organizations")
}
                                                

// @LINE:8
def idioma(codigo:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "idioma/" + implicitly[PathBindable[String]].unbind("codigo", dynamicString(codigo)))
}
                                                

// @LINE:7
def page(page:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "page/" + implicitly[PathBindable[Integer]].unbind("page", page))
}
                                                

// @LINE:13
def register(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "registro")
}
                                                

// @LINE:11
def discover(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "discover")
}
                                                

// @LINE:10
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:9
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:15
class ReverseAPI {
    

// @LINE:23
def followsByIDUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.API.followsByIDUser",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/follows/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:15
def crawler : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.API.crawler",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "crawler"})
      }
   """
)
                        

// @LINE:24
def ajax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.API.ajax",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajaxE"})
      }
   """
)
                        

// @LINE:22
def observationsByIndicator : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.API.observationsByIndicator",
   """
      function(indicator) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/observations/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("indicator", encodeURIComponent(indicator))})
      }
   """
)
                        
    
}
              

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:14
def registerAut : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registerAut",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registro"})
      }
   """
)
                        

// @LINE:12
def organizations : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.organizations",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "organizations"})
      }
   """
)
                        

// @LINE:8
def idioma : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.idioma",
   """
      function(codigo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "idioma/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("codigo", encodeURIComponent(codigo))})
      }
   """
)
                        

// @LINE:7
def page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.page",
   """
      function(page) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "page/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("page", page)})
      }
   """
)
                        

// @LINE:13
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registro"})
      }
   """
)
                        

// @LINE:11
def discover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.discover",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "discover"})
      }
   """
)
                        

// @LINE:10
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:15
class ReverseAPI {
    

// @LINE:23
def followsByIDUser(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.API.followsByIDUser(id), HandlerDef(this, "controllers.API", "followsByIDUser", Seq(classOf[Long]), "GET", """""", _prefix + """api/follows/$id<[^/]+>""")
)
                      

// @LINE:15
def crawler(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.API.crawler(), HandlerDef(this, "controllers.API", "crawler", Seq(), "GET", """""", _prefix + """crawler""")
)
                      

// @LINE:24
def ajax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.API.ajax(), HandlerDef(this, "controllers.API", "ajax", Seq(), "GET", """""", _prefix + """ajaxE""")
)
                      

// @LINE:22
def observationsByIndicator(indicator:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.API.observationsByIndicator(indicator), HandlerDef(this, "controllers.API", "observationsByIndicator", Seq(classOf[String]), "GET", """ API""", _prefix + """api/observations/$indicator<[^/]+>""")
)
                      
    
}
                          

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:14
def registerAut(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registerAut(), HandlerDef(this, "controllers.Application", "registerAut", Seq(), "POST", """""", _prefix + """registro""")
)
                      

// @LINE:12
def organizations(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.organizations(), HandlerDef(this, "controllers.Application", "organizations", Seq(), "GET", """""", _prefix + """organizations""")
)
                      

// @LINE:8
def idioma(codigo:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.idioma(codigo), HandlerDef(this, "controllers.Application", "idioma", Seq(classOf[String]), "GET", """""", _prefix + """idioma/$codigo<[^/]+>""")
)
                      

// @LINE:7
def page(page:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.page(page), HandlerDef(this, "controllers.Application", "page", Seq(classOf[Integer]), "GET", """""", _prefix + """page/$page<[^/]+>""")
)
                      

// @LINE:13
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Seq(), "GET", """""", _prefix + """registro""")
)
                      

// @LINE:11
def discover(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.discover(), HandlerDef(this, "controllers.Application", "discover", Seq(), "GET", """""", _prefix + """discover""")
)
                      

// @LINE:10
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        
    