package models;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

public class InstantTime implements Time {

	private String instant;

	public InstantTime(String instant) {
		this.instant = instant;
	}

	@Override
	public Time getStart() {
		return this;
	}

	@Override
	public Time getEnd() {
		return this;
	}

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

	@Override
	public String toString() {
		return instant;
	}
	
	/*public static JsonNode toJson(InstantTime time) {
		return Json.toJson(time);
	  }*/

}
