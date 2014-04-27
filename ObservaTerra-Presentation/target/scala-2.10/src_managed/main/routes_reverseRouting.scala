// @SOURCE:/Users/Sergio/ObservaTerra31/ObservaTerra-Presentation/conf/routes
// @HASH:86ce79701c4f6a1e0ec832f90c2a644c3ee15977
// @DATE:Tue Apr 22 19:33:15 CEST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:20
// @LINE:19
// @LINE:15
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:20
// @LINE:19
class ReverseAPI {
    

// @LINE:20
def ajax(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ajaxE")
}
                                                

// @LINE:19
def observationsByIndicator(indicator:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/observations/" + implicitly[PathBindable[String]].unbind("indicator", dynamicString(indicator)))
}
                                                
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:11
def organizations(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "organizations")
}
                                                

// @LINE:7
def idioma(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "idioma")
}
                                                

// @LINE:10
def discover(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "discover")
}
                                                

// @LINE:9
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:20
// @LINE:19
// @LINE:15
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:20
// @LINE:19
class ReverseAPI {
    

// @LINE:20
def ajax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.API.ajax",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajaxE"})
      }
   """
)
                        

// @LINE:19
def observationsByIndicator : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.API.observationsByIndicator",
   """
      function(indicator) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/observations/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("indicator", encodeURIComponent(indicator))})
      }
   """
)
                        
    
}
              

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:11
def organizations : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.organizations",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "organizations"})
      }
   """
)
                        

// @LINE:7
def idioma : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.idioma",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "idioma"})
      }
   """
)
                        

// @LINE:10
def discover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.discover",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "discover"})
      }
   """
)
                        

// @LINE:9
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
                        

// @LINE:8
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
        


// @LINE:20
// @LINE:19
// @LINE:15
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:20
// @LINE:19
class ReverseAPI {
    

// @LINE:20
def ajax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.API.ajax(), HandlerDef(this, "controllers.API", "ajax", Seq(), "GET", """""", _prefix + """ajaxE""")
)
                      

// @LINE:19
def observationsByIndicator(indicator:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.API.observationsByIndicator(indicator), HandlerDef(this, "controllers.API", "observationsByIndicator", Seq(classOf[String]), "GET", """ API""", _prefix + """api/observations/$indicator<[^/]+>""")
)
                      
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:11
def organizations(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.organizations(), HandlerDef(this, "controllers.Application", "organizations", Seq(), "GET", """""", _prefix + """organizations""")
)
                      

// @LINE:7
def idioma(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.idioma(), HandlerDef(this, "controllers.Application", "idioma", Seq(), "GET", """""", _prefix + """idioma""")
)
                      

// @LINE:10
def discover(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.discover(), HandlerDef(this, "controllers.Application", "discover", Seq(), "GET", """""", _prefix + """discover""")
)
                      

// @LINE:9
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        
    