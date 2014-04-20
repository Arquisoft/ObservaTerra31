package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.types.ScopeEnum;
import play.db.ebean.Model;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Representa un area demografica determinada. Un area tiene un nombre, un
 * ambito y una lista de observaciones asociadas.
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="Area")
public class Area extends Model {

	private static final long serialVersionUID = 912447239788457979L;
	
	public static Finder<Long,Area> find = 
			new Finder<Long,Area>(Long.class, Area.class);
	
	@Id @GeneratedValue
	public Long id;
	public String name;
	@Enumerated(EnumType.STRING)
	public ScopeEnum scope;
	
	@OneToMany(mappedBy = "area")
	private Set<Observation> observations = new HashSet<Observation>();

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public Area(){}
	
	public Area(String name, ScopeEnum scope) {
		super();
		this.name = name;
		this.scope = scope;
	}
	 
	// // // // // // //
	// METODOS PLAY
	// // // // // // //
	
	public static List<Area> all() {
		return find.all();
	}

	public static void create(Area area) {
		if (Area.findByName(area.name) == null) {
			area.save();
		}
	}

	public static void remove(long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (Area a : all())
			a.delete();
	}
	
	public static Area findById(Long id) {
		return find.byId(id);
	}

	public static Area findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}

	/**
	 * Devuelve una lista de Areas cuya lista de Observations contenga la
	 * Observation recibida por parametro
	 */
	public static List<Area> findByObservation(Long observationId) {
		return find.where().eq("observations.id", observationId).findList();
	}

	public static JsonNode toJson(Area area) {
		return Json.toJson(area);
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/*
	 * Relacion entre entidades:
	 * 1 Area <--> Observations
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
	
	public String getName() {
		return name;
	}
	
	public ScopeEnum getScope() {
		return scope;
	}

	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Area other = (Area) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
