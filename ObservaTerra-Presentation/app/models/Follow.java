package models;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;



/**
 * Representa la suscripccion de un usuario a cierto indicador.
 * 
 * @author Sergio
 * 
 */

public class Follow {

	private Indicator indicator;
	private User user;

	public Follow(Indicator indicator, User user) {
		this.indicator = indicator;
		this.user = user;
		link();
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public User getUser() {
		return user;
	}

	private void link() {
		indicator._getFollows().add(this);
		user._getFollows().add(this);
	}

	public void unlink() {
		indicator._getFollows().remove(this);
		user._getFollows().remove(this);
	}
	
	public static JsonNode toJson(Follow follow) {
		return Json.toJson(follow);
	  }

}
