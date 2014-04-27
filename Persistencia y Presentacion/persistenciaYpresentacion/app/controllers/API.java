package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Indicator;
import models.Observation;
import models.Organization;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Jsonin;
import views.html.ajaxE;

public class API extends Controller {

	public static Result allObservations() {
		/*
		 * List<Observation> obs = PersistenceSimulator.getInstance()
		 * .getObservations(); String ret = Jsonin.observations2json(obs);
		 * return ok(ret);
		 */

		List<Observation> obs = Observation.all();
		String ret = Jsonin.observations2json(obs);
		return ok(ret);
	}

	public static Result observationsByIndicator(String indicator) {
		/*
		 * List<Observation> obs = PersistenceSimulator.getInstance()
		 * .findObservations(indicator); String ret =
		 * Jsonin.observations2json(obs); return ok(ret);
		 */
		List<Indicator> indicators = Indicator.filterByName(indicator);
		List<Observation> obs = new ArrayList<Observation>();
		for (Indicator ind: indicators)
			obs.addAll(Observation.findByIndicator(ind));
		//List<Observation> obs = Observation.findByIndicator(ind);
		String ret = Jsonin.observations2json(obs);
		return ok(ret);
	}

	public static Result observationsByProvider(String providerName) {
		Organization org = Organization.findByName(providerName);
		List<Observation> obs = Observation.findByProvider(org);
		String ret = Jsonin.observations2json(obs);
		return ok(ret);
	}

	public static Result allOrganizations() {
		List<Organization> orgs = null;//Organization.findAll();
		String ret = Jsonin.organizations2json(orgs);
		return ok(ret);

	}

	public static Result arganizationsByName(String name) {
		Organization org = Organization.findByName(name);
		return ok(org.toJson());
	}

	public static Result arganizationsByID(Long id) {
		Organization org = Organization.findById(id); 
		return ok (org.toJson());
	}

	public static Result ajax() {
		return ok(ajaxE.render());
	}
}
