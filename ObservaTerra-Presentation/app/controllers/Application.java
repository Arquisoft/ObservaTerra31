package controllers;

import persistence.PersistenceSimulator;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Started...", PersistenceSimulator.getInstance().getObservations()));
    }
/*
    public static Result showCountries() {
    	return ok(country.render(Country.all(),countryForm));
    }
    
    public static Result showIndicators() {
    	return ok(indicator.render(Indicator.all(),indicatorForm));
    }
    
    public static Result showObservations() {
    	return ok(observation.render(Observation.find.all(),Country.all(),Indicator.all(),observationForm));
    }
    
    public static Result bars(String indicator) {
    	return ok(comparator.render(PersistenceSimulator.getInstance().findHVIObservations()));
    }*/
    
    public static Result change(String langCode) {

    	changeLang(langCode);

    	return ok();

    	}
    
    public static Result idioma(){
    	return TODO;
    }
   

}
