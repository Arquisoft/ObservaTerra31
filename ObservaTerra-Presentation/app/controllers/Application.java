package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import models.*;

import models.Indicator;
import models.Observation;

import views.html.*;

import persistence.PersistenceSimulator;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Real Nigga Shit", PersistenceSimulator.getInstance().getObservations()));
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
    	return ok(bars.render(Indicator.findByCode(indicator)));
    }
*/
   

}
