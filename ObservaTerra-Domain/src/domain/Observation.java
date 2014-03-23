package domain;

import java.util.Date;

/**
 * Representa una observacion.
 * 
 * @author Sergio
 * 
 */
public class Observation {

	private Time time;
	private String measure;
	private Indicator indicator;
	private Area area;
	private Organization provider;
	private Date publishDate;

	public Observation(Time time, String measure, Indicator indicator,
			Area area, Organization provider, Date publishDate) {
		super();
		this.time = time;
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

	public Area getArea() {
		return area;
	}

	public Organization getProvider() {
		return provider;
	}

	public Date getPublishDate() {
		return publishDate;
	}

}
