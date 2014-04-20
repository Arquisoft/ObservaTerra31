package controllers;

import models.Area;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.area;

public class Application extends Controller {

    public static Result index() {
        //return ok(index.render(Observation.all(),Area.all(),Indicator.all()));
    	return ok(index.render(Area.all()));
    }
    
    public static Result showAreas() {
    	return ok(area.render(Area.all(),areaForm));
    }
    static Form<Area> areaForm = Form.form(Area.class);
}
