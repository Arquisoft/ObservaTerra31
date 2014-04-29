package controllers;

import java.util.Map;

import models.Observation;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Volcado;
import views.html.discover;
import views.html.index;
import views.html.login;
import views.html.organizations;


public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Started...", Observation.all()));
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

			User us = User.findByEmail(email);
			Volcado.getInstance().volcar(email,pass);
			if(us != null && us.getPassword().equalsIgnoreCase(pass))
				return redirect(routes.Application.index());
			else
				return redirect(routes.Application.login());
		}
	}
	
	public static Result register() {
		return redirect(routes.Application.index());
		
	}
	
}
