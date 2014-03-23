package domain;

/**
 * Representa un intervalo de tiempo. Esta construido mediante un patron
 * composite. Cada rango tiene un punto inicial y final.
 * 
 * @author Sergio
 * 
 */
public class RangeTime implements Time {

	private Time start;
	private Time end;

	public RangeTime(Time start, Time end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public Time getStart() {
		return start;
	}

	@Override
	public Time getEnd() {
		return end;
	}

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

}
