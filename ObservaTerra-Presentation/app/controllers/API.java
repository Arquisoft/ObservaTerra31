package controllers;

import java.util.List;

import models.Observation;
import persistence.PersistenceSimulator;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Jsonin;

public class API  extends Controller {
	
	  public static Result observationsByIndicator(String indicator) {
		 List<Observation> obs = PersistenceSimulator.getInstance().findHVIObservations();
		 
		 return ok(Jsonin.observations2json(obs));
	    }

}
