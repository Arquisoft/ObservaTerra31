package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Follow;
import models.Indicator;
import models.Observation;
import models.Organization;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Jsonin;
import views.html.ajaxE;
import views.html.crawler;
import business.main.java.procesadores.Procesador;
import business.main.java.procesadores.ProcesadorLM;
import business.main.java.procesadores.ProcesadorUN;

public class API extends Controller {

	public static Result allObservations() {
		List<Observation> obs = Observation.all();
		String ret = Jsonin.observations2json(obs);
		return ok(ret);
	}

	public static Result observationsByIndicator(String indicator) {

		List<Indicator> indicators = Indicator.filterByName(indicator);
		List<Observation> obs = new ArrayList<Observation>();
		for (Indicator ind: indicators)
			obs.addAll(Observation.findByIndicator(ind));
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
		List<Organization> orgs = Organization.findAll();
		String ret = Jsonin.organizations2json(orgs);
		return ok(ret);
	}
	
	public static Result followsByIDUser(Long id){
		List<Follow> follows = Follow.findByUserId(id);
		return ok(Jsonin.follow2json(follows));
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
	
	public static Result crawler(){
		Procesador procesadorUN = new ProcesadorUN();
		Procesador procesadorLM = new ProcesadorLM();
		
		runProcessor(procesadorUN);
		runProcessor(procesadorLM);
		
		return ok(crawler.render());
	}
	
	private static void runProcessor(Procesador procesador){
		System.out.println(
				"\nData from " + procesador.getOrganization().getName() + 
				" are being processed. Please, wait. " +
				"\nThis may take about five minutes...");
		
		procesador.procesar();
		
		System.out.println(
				"\nProcess completed. Data from " + 
				procesador.getOrganization().getName() + 
				" have been treated.");
				
		List<Observation> obs = Observation.all();
		System.out.println(
				"\nNow there are " + obs.size() + " observations in data bases");
	}
}
