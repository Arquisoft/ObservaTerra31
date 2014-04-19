package models;

import java.util.Date;

import play.i18n.Messages;

/**
 * Representa una observacion.
 * 
 * @author Sergio
 * 
 */

public class Observation {

	private Long id;
	private Time time;
	private String value;
	private String measure;
	private Indicator indicator;
	private Area area;
	private Organization provider;
	private Date publishDate;

	public Observation(Long id, Time time, String value, String measure,
			Indicator indicator, Area area, Organization provider,
			Date publishDate) {

		this.id = id;
		this.time = time;
		this.value = value;
		this.measure = measure;
		this.indicator = indicator;
		this.area = area;
		this.provider = provider;
		this.publishDate = publishDate;

		provider._getObservations().add(this);
		area._getObservations().add(this);
		indicator._getObservations().add(this);
	}

	public Time getTime() {
		return time;
	}

	public String getMeasure() {
		return measure;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public String getValue() {
		return value;
	}

	public Area getArea() {
		return area;
	}

	public Organization getProvider() {
		return provider;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	@Override
	public String toString() {
		return indicator + " " + Messages.get("at") + " " + time
				+ Messages.get("in") + " " + area + " " + Messages.get("was")
				+ " " + value + (measure.length() == 1 ? "" : " ") + measure
				+ " " + Messages.get("by") + provider + ".";

	}

	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"" + id + "\"");
		sb.append(",\"time\": ").append("\"" + time.toString() + "\"");
		sb.append(",\"value\": ").append("\"" + value + "\"");
		sb.append(",\"measure\": ").append("\"" + measure + "\"");
		sb.append(",\"indicator\": ")
				.append("\"" + indicator.toString() + "\"");
		sb.append(",\"area\": ").append("\"" + area.toString() + "\"");
		sb.append(",\"provider\": ").append("\"" + provider.toString() + "\"");
		sb.append(",\"publishDate\": ").append(
				"\"" + publishDate.toString() + "\"");
		sb.append("}");
		return sb.toString();
	}

	public Long getId() {
		return id;
	}

}
