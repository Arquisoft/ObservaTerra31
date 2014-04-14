package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Representa un area demografica determinada. Un area tiene un nombre, un
 * ambito y una lista de observaciones asociadas.
 * 
 * @author Sergio
 * 
 */

public class Area {

	public String name;
	public ScopeEnum scope;
	private Set<Observation> observations = new HashSet<Observation>();

	public Area(String name, ScopeEnum scope) {
		super();
		this.name = name;
		this.scope = scope;
	}

	public String getName() {
		return name;
	}

	public ScopeEnum getScope() {
		return scope;
	}

	public Set<Observation> getObservations() {
		return Collections.unmodifiableSet(observations);
	}

	public Set<Observation> _getObservations() {
		return observations;
	}

	@Override
	public String toString() {
		return name;
	}

	public static JsonNode toJson(Area area) {
		return Json.toJson(area);
	  }

}
