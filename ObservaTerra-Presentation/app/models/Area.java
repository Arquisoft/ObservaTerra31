package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

	public String toJson() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		  .append("\"name\": \"").append(name).append("\"")
		  .append("\"scope\": \"").append(scope.name()).append("\"")
		  .append("}");
		
		return sb.toString();
	  }

}
