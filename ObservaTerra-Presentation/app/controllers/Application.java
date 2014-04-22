package controllers;

import models.User;
import persistence.PersistenceSimulator;
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
		return TODO;
		
		/*
	    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
	    if (loginForm.hasErrors()) {
	        return badRequest(login.render(loginForm));
	    } else {
	        session().clear();
	        session("user", loginForm.get().getId());
	        return redirect(
	            routes.Application.index()
	        );
	    }*/
	}
	
	

}
