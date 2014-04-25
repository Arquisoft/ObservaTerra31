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

	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //
	
	@Override
	public Time getStart() {
		return this;
	}

	@Override
	public Time getEnd() {
		return this;
	}

	public String getInstant() {
		return instant;
	}
	
	public void setInstant(String instant) {
		this.instant = instant;
	}
	
	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instant == null) ? 0 : instant.hashCode());
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
		InstantTime other = (InstantTime) obj;
		if (instant == null) {
			if (other.instant != null)
				return false;
		} else if (!instant.equals(other.instant))
			return false;
		return true;
	}

	// // // // //
	// TO_STRING
	// // // // //
	
	@Override
	public String toString() {
		return getInstant();
	}
}
