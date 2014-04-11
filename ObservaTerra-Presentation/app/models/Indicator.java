package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
	
	

}
