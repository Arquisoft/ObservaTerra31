package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="InstantTime")
public class InstantTime extends Time {
	
	private static final long serialVersionUID = -9043190137179176327L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	private String instant;

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public InstantTime(){}
	
	public InstantTime(String instant) {
		super();
		this.instant = instant;
	}

	// // // // // // // // // //
	// METODOS PERSISTENCIA PLAY
	// // // // // // // // // //
	
	/**
	 * Trata de insertar un InstantTime en la base de datos.
	 * @param newTime Time a insertar
	 * @return Devuelve un Time. <br>
	 * Si tiene exito, devuelve el Time insertado.
	 * Si ya exitia, devuelve el Time existente.
	 */
	public Time create(Time newTime) {
		String instant = ((InstantTime)newTime).getInstant();
		
		Time alreadyExisting = findByInstant( instant );
		if( alreadyExisting == null ){
			newTime.save();
			return newTime;
		}
		return alreadyExisting;
	}

	public Time findByInstant(String instant) {
		return find.where().eq("instant", instant).findUnique();
	}
	
	public Time findByRange(Time start, Time end){
		String instantStart = ((InstantTime)start).getInstant();
		String instantEnd = ((InstantTime)end).getInstant();
		if( instantStart == instantEnd )
			return find.where().eq("instant", instantStart).findUnique();
		return null;
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //
	
	public Long getId() {
		return id;
	}
	
	public Time getStart() {
		return this;
	}

	public Time getEnd() {
		return this;
	}
	
	public String getInstant() {
		return instant;
	}
	
	public void setInstant(String instant) {
		this.instant = instant;
	}
	
	// // // // //
	// TO_STRING
	// // // // //
	
	@Override
	public String toString() {
		return getInstant();
	}
}
