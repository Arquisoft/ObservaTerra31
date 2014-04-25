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

	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //
	
	@Override
	public Time getStart() {
		return start;
	}

	@Override
	public Time getEnd() {
		return end;
	}

	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		RangeTime other = (RangeTime) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	// // // // //
	// TO_STRING
	// // // // //
	
	@Override
	public String toString() {
		String start = getStart() instanceof InstantTime ? getStart()
				.toString().split(" ")[1] : getStart().toString();
		String end = getEnd() instanceof InstantTime ? getEnd().toString()
				.split(" ")[1] : getEnd().toString();
				
		return  start.toLowerCase() + "-" + end.toLowerCase();
	}
}
