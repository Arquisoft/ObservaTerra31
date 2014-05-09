package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


/**
 * Representa un intervalo de tiempo. Esta construido mediante un patron
 * composite. Cada rango tiene un punto inicial y final.
 * 
 * @author Sergio
 * 
 */

@Entity
@DiscriminatorValue(value="RangeTime")
public class RangeTime extends Time {
	
	private static final long serialVersionUID = 1L;

	// // // // //
	// ATRIBUTOS
	// // // // //
	
	@OneToOne
	private Time start;
	@OneToOne
	private Time end;
	
	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public RangeTime() {}
	
	public RangeTime(Time start, Time end) {
		super();
		this.start = start;
		this.end = end;
	}

	// // // // // // // // // //
	// METODOS PERSISTENCIA PLAY
	// // // // // // // // // //
	
	/**
	 * Trata de insertar un RangeTime en la base de datos.
	 * @param newTime Time a insertar
	 * @return Devuelve un Time. <br>
	 * Si tiene exito, devuelve el Time insertado.
	 * Si ya exitia, devuelve el Time existente.
	 */
	public Time create(Time newTime) {
		Time startTime = ((RangeTime)newTime).getStart();
		Time endTime = ((RangeTime)newTime).getEnd();
		
		Time alreadyExisting = findByRange(startTime, endTime);
		if( alreadyExisting == null ){
			newTime.save();
			return newTime;
		}
		return alreadyExisting;
	}

	public Time findByInstant(String instant) {
		return find.where().betweenProperties("start", "end", instant)
				.findUnique();
	}
	
	public Time findByRange(Time start, Time end){
		return find.where().eq("start", start).eq("end", end)
				.findUnique();
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //
	
	public Long getId() {
		return id;
	}
	
	public Time getStart() {
		return start;
	}

	public Time getEnd() {
		return end;
	}

	public String getInstant() {
		return null;
	}

	public void setInstant(String instant) {}

	// // // // //
	// TO_STRING
	// // // // //
	
	@Override
	public String toString() {
		String start = getStart().toString();
		String end = getEnd().toString();
		return  start.toLowerCase() + "-" + end.toLowerCase();
	}
}
