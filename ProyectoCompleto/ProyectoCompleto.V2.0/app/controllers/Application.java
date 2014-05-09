package controllers;

import java.util.List;
import java.util.Map;

import models.Observation;
import models.Organization;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Hashin;
import utils.Volcado;
import views.html.discover;
import views.html.index;
import views.html.login;
import views.html.organizations;
import views.html.registro;

public class Application extends Controller {

	public static Result page(int page) {
		List<Observation> obs = Observation.all();
		int start = 21*page;
		if(obs.size() <= 20 )
			return ok(index.render("Started...", obs, 1));
		if(page < 0)
			return redirect("/page/1");
		return ok(index.render("Started...", obs.subList(start, start+20), page));
	}
	
	public static Result index() {
		return redirect("/page/1");
	}

	public static Result change(String langCode) {
		changeLang(langCode);
		return ok();
	}

	public static Result idioma(String langCode) {
		changeLang(langCode);
		return redirect(routes.Application.index());
	}

	public static Result login() {
		return ok(login.render(Form.form(User.class)));
	}

	public static Result discover() {
		return ok(discover.render());
	}

	public static Result organizations() {
		return ok(organizations.render(Organization.all()));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		System.out.println(loginForm.hasErrors());
		if (loginForm.hasErrors())
			return badRequest("algo has hecho mal");
		else {
			Map<String, String[]> values = request().body().asFormUrlEncoded();
			String email = values.get("emailLog")[0];
			String pass = Hashin.md5(values.get("passLog")[0]);
			
			User us = User.findByEmail(email);
			
			Volcado.getInstance().volcar(email, pass);
			
			if (us != null && us.getPassword().equalsIgnoreCase(pass))
				return redirect(routes.Application.index());
			else
				return redirect(routes.Application.login());
		}
	}

	public static Result register() {
		return ok(registro.render(Form.form(User.class)));

	}

	public static Result registerAut() {
	
		Form<User> loginForm = Form.form(User.class).bindFromRequest();
		 if (loginForm.hasErrors())
			return badRequest("algo has hecho mal");
		else {
			
			Map<String, String[]> values = request().body().asFormUrlEncoded();
			String email = values.get("emailReg")[0];
			String password = values.get("passReg")[0];
			String name = values.get("nameReg")[0];
			String surname = values.get("surnameReg")[0];
			User user = new User(name, surname, email, password);
			User.create(user);
			return redirect(routes.Application.index());
		}
	}
}
