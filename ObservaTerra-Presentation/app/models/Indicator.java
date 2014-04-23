package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Representa el objeto de estudio de una observacion.
 * 
 * @author Sergio
 * 
 */
public class Indicator {

	private String name;
	private Set<Follow> follows = new HashSet<Follow>();
	private Set<Observation> observations = new HashSet<Observation>();

	public Indicator(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected Set<Follow> _getFollows() {
		return follows;
	}

	protected Set<Observation> _getObservations() {
		return observations;
	}

	public Set<Follow> getFollows() {
		return Collections.unmodifiableSet(follows);
	}

	public Set<Observation> getObservations() {
		return Collections.unmodifiableSet(observations);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static JsonNode toJson(Indicator indicator) {
		return Json.toJson(indicator);
	  }
	
	public String toJson() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		  .append("\"name\": \"").append(name).append("\"")
		  .append("}");
		
		return sb.toString();
	  }
	

}
