package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

/**
 * Clase abstracta que representa un instante temporal, bien puede ser un ano
 * concreto o un intervalo.
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="Time")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="time_type")
public abstract class Time extends Model{
	
	private static final long serialVersionUID = 3579790483353447092L;
	
	@Id @GeneratedValue
	private Long id;
	@OneToMany(mappedBy = "time")
	private Set<Observation> observations = new HashSet<Observation>();
	
	public Time(){}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //

	/*
	 * Relacion entre entidades:
	 * 1 Time <--> * Observations
	 */
	public Set<Observation> _getObservations() {
		return observations;
	}
	public Set<Observation> getObservations() {
		return Collections.unmodifiableSet(observations);
	}
	public void setObservations(Set<Observation> obs) {
		observations = obs;
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //

	public Long getId() {
		return id;
	}
	
	abstract Time getStart();

	abstract Time getEnd();
	
	// // // // //
	// TO_STRING
	// // // // //
	
	public abstract String toString();
}
