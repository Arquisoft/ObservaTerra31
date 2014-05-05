package business.main.java.parser;

import java.util.Date;

import models.*;

/**
 * Clase abstracta que contiene la logica basica para todos los parsers,
 * que actualmente se reduce a almacenar los datos que posteriormente
 * se utilizaran para la generacion de Observaciones.
 * @author Victor
 *
 */
public abstract class AbstractParser implements Parser {

	protected Time time;
	protected String value;
	protected String measure;
	protected Indicator indicator;
	protected Area area;
	protected Organization provider;
	protected Date publishDate;

	protected void setTime(Time time) {
		this.time = time;
	}

	protected void setValue(String value) {
		this.value = value;
	}

	protected void setMeasure(String measure) {
		this.measure = measure;
	}

	protected void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	protected void setArea(Area area) {
		this.area = area;
	}

	public void setProvider(Organization provider) {
		this.provider = provider;
	}

	protected void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
}
