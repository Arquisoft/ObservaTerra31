package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="Time")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="time_type")
public class Time extends Model{
	
	/*
	 * Un mejor diseno requiriria que esta clase sea abstracta.
	 * Pero cuando una clase abstracta posee una coleccion de entidades
	 * (en este caso, Set observatons) se produce un error (no entro en detalle),
	 * debido a un bug de Ebean: http://www.avaje.org/bugdetail-408.html
	 * 
	 * El error se produciria al anadir una Observation al Time,
	 * como sucede por ejemplo en Observation.link().
	 */
	
	private static final long serialVersionUID = 3579790483353447092L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	public static Finder<Long,Time> find = 
			new Finder<Long,Time>(Long.class, Time.class);
	
	@Id @GeneratedValue
	protected Long id;
	@OneToMany(mappedBy = "time")
	protected Set<Observation> observations = new HashSet<Observation>();
	
	public Time(){}
	
	// // // // // // // // // // // // //
	// METODOS PERSISTENCIA ACTIVE RECORD
	// // // // // // // // // // // // //
	
	public static List<Time> all(){
		return find.all();
	}

	public static void remove(long id){
		find.ref(id).delete();
	}

	public static void deleteAll(){
		for (Time t : all())
			t.delete();
	}

	public static Time findById(Long id){
		return find.byId(id);
	}
	
	/**
	 * Devuelve una lista de Times cuya lista de Observations contenga
	 *  la Observation recibida por parametro
	 */
	public static List<Time> findByObservation(Long observationId) {
		return find.where().eq("observations.id", observationId).findList();
	}
	
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

	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
