package models;


/**
 * Representa un intervalo de tiempo. Esta construido mediante un patron
 * composite. Cada rango tiene un punto inicial y final.
 * 
 * @author Sergio
 * 
 */

public class RangeTime extends Time {
	
	private Time start;
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
}
