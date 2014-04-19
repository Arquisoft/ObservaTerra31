package controllers;

import java.util.List;

import models.Observation;
import persistence.PersistenceSimulator;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Jsonin;
import views.html.*;

public class API  extends Controller {
	
	  public static Result observationsByIndicator(String indicator) {
		 List<Observation> obs = PersistenceSimulator.getInstance().findHVIObservations();
		 String ret = Jsonin.observations2json(obs);
		 return ok(ret);
	    }

	  public static Result ajax() {
		  return ok (ajaxE.render());
	  }
	  
}
