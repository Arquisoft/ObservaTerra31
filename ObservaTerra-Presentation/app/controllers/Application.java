package controllers;

import java.awt.image.renderable.RenderableImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import models.User;
import persistence.PersistenceSimulator;
import persistence.Volcado;
import play.data.*;
import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Started...", PersistenceSimulator.getInstance()
				.getObservations()));
	}

	public static Result change(String langCode) {
		changeLang(langCode);
		return ok();
	}

	public static Result idioma() {
		return TODO;
	}
	
	public static Result login(){
		return ok(login.render(Form.form(User.class)));
	}
	
	public static Result discover(){
		return ok(discover.render());
	}
	
	public static Result organizations(){
		return ok(organizations.render());
	}
	
	public static Result authenticate() {
		
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
	    if (loginForm.hasErrors()) {
	        return badRequest("algo has hecho mal");
	    }else{
	    	Map<String, String[]> values = request().body().asFormUrlEncoded();
	    	String email = values.get("emailLog")[0];
	    	String pass = values.get("passLog")[0];
	    	
	    	User us = PersistenceSimulator.getInstance().loginService(email,pass);
	    	Volcado.getInstance().volcar(email,pass);
	    	if(us == null)
	    		return redirect(routes.Application.login());
	    	else
	    		return redirect(routes.Application.index());
	    }
	}

	
	
	

}
