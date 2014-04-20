package models;



public class InstantTime extends Time {

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
}
