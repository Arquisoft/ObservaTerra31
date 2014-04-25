package controllers;

import models.Observation;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Language extends Controller {
	
	
	public static Result index() {
        //return ok(index.render("Started...", PersistenceSimulator.getInstance().getObservations()));
		return ok(index.render("Started...", Observation.all()));
    }

}
