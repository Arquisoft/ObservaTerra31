package controllers;

import persistence.PersistenceSimulator;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Language extends Controller {
	
	
	public static Result index() {
        return ok(index.render("Started...", PersistenceSimulator.getInstance().getObservations()));
    }

}
