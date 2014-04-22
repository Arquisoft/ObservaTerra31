package controllers;

import java.util.List;

import models.Observation;
import persistence.PersistenceSimulator;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Jsonin;
import views.html.*;

public class API extends Controller {
	
	
	public static Result allObservations() {
		List<Observation> obs = PersistenceSimulator.getInstance()
				.getObservations();
		String ret = Jsonin.observations2json(obs);
		return ok(ret);
	}

	public static Result observationsByIndicator(String indicator) {
		List<Observation> obs = PersistenceSimulator.getInstance()
				.findObservations(indicator);
		String ret = Jsonin.observations2json(obs);
		return ok(ret);
	}

	public static Result observationsByYear(String year) {
		return TODO;
	}

	public static Result observationsByProvider(String providerName) {
		return TODO;
	}

	public static Result observationsByArea(String areaName) {
		return TODO;
	}
	
	public static Result allOrganizations(){
		return TODO;
	}
	
	public static Result arganizations(){
		return TODO;
	}
	
	public static Result arganizationsByName(String name){
		return TODO;
	}
	
	public static Result arganizationsByNumberOfMembers(int membersCount){
		return TODO;
	}
	

	public static Result ajax() {
		return ok(ajaxE.render());
	}

}
