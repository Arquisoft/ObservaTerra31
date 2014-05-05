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
	
	public Time create(Time time) {
		Time startTime = ((RangeTime)time).getStart();
		Time endTime = ((RangeTime)time).getEnd();
		if (findByRange(startTime, endTime) == null) {
			time.save();
			return time;
		}
		return null;
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
