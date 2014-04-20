package controllers;

import models.Area;
//import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Admin extends Controller {

    public static Result newArea() {
      Form<Area> form = areaForm.bindFromRequest();
  	  if(form.hasErrors()) {
  	    return badRequest(
  	      views.html.area.render(Area.all(),areaForm)
  	    );
  	  } else {
  		Area areaToAdd = form.get();
  		Area.create(areaToAdd);
  	    return redirect(routes.Application.showAreas());
  	  }
    }
    
    public static Result deleteArea(Long id) {
    	Area.remove(id);
        return redirect(routes.Application.showAreas());
    }

    /*
    public static Result newObservation() {
      DynamicForm requestData = Form.form().bindFromRequest();
      String countryId = requestData.get("countryId");
      String indicatorId = requestData.get("indicatorId");
      Long countryCodeLong = Long.parseLong(countryId);
      Long indicatorCodeLong = Long.parseLong(indicatorId);
      
      // Indicator indicator = Indicator.findById(indicatorId)
      // User user = User.findById(userId)
      // Follow = new Follow(indicator,user);
      
      Double value = Double.parseDouble(requestData.get("value"));
      Observation obs = new Observation(
    		  countryCodeLong,indicatorCodeLong,value);
	  obs.save();
  	  return redirect(routes.Application.showObservations());  
    }
    */
    
    static Form<Area> areaForm = Form.form(Area.class);
}
