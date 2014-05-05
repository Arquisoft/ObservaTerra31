package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Representa el objeto de estudio de una observacion.
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name = "Indicator")
public class Indicator extends Model {

	private static final long serialVersionUID = -8890932988021221797L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	public static Finder<Long,Indicator> find = 
			new Finder<Long,Indicator>(Long.class, Indicator.class);
	
	@Id @GeneratedValue
	public Long id;
	private String name;
	@OneToMany(mappedBy = "indicator")
	private Set<Follow> follows = new HashSet<Follow>();
	@OneToMany(mappedBy = "indicator")
	private Set<Observation> observations = new HashSet<Observation>();

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //

	public Indicator(){}
	
	public Indicator(String name) {
		super();
		this.name = name;
	}

	// // // // // // // // // //
	// METODOS PERSISTENCIA PLAY
	// // // // // // // // // //
	
	public static List<Indicator> all() {
		return find.all();
	}

	public static Indicator create(Indicator indicator) {
		if (Indicator.findByName(indicator.name) == null) {
			indicator.save();
			return indicator;
		}
		return null;
	}

	public static void remove(long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (Indicator i : all())
			i.delete();
	}

	public static Indicator findById(Long id) {
		return find.byId(id);
	}
	
	public static Indicator findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}
	
	public static List<Indicator> filterByName(String name) {
		return find.where().contains("name", name).findList();
	}
	
	/**
	 * Devuelve una lista de Indicators cuya lista de Observations contenga la
	 * Observation recibida por parametro
	 */
	public static List<Indicator> findByObservation(Long observationId) {
		return find.where().eq("observations.id", observationId).findList();
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //

	/*
	 * Relacion entre entidades:
	 * 1 Indicator <--> * Observations
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

	/*
	 * Relacion entre entidades:
	 * 1 Indicator <--> * Follows
	 */
	protected Set<Follow> _getFollows() {
		return follows;
	}
	public Set<Follow> getFollows() {
		return Collections.unmodifiableSet(follows);
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indicator other = (Indicator) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	// // // // // // // //
	// TO_STRING & TO_JSON
	// // // // // // // //
	
	@Override
	public String toString() {
		return getName();
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
