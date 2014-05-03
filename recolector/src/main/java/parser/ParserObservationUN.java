package parser;

import javax.xml.stream.XMLStreamReader;

import domain.Area;
import domain.Indicator;
import domain.InstantTime;
import domain.Observation;
import domain.RangeTime;
import domain.ScopeEnum;

/**
 * Implementación del ParserObservationXml para las observaciones provenientes
 * de las naciones unidas.
 * 
 * @author Victor
 * 
 */
public class ParserObservationUN extends ParserObservationXml {
	// Expresion regular del formato de los RangeTime en las observaciones de la
	// UN.
	private String rangeTime = "_[0-9][0-9][0-9][0-9]_[0-9][0-9][0-9][0-9].+";
	// Expresion regular del formato de los InstantTime en las observaciones de
	// la UN.
	private String instantTime = "_[0-9][0-9][0-9][0-9].+";
	private String hdi = "_[0-9][0-9][0-9][0-9]_hdi.+";
	private String porcent = "0.[0-9][0-9][0-9]";
	private String unit = "[1-9]+.[0-9][0-9][0-9]";

	public ParserObservationUN(String filename) {
		super(filename);

	}

	@Override
	String processElementEnd(XMLStreamReader r, String name) {
		if (name.matches(rangeTime) || name.matches(instantTime)
				&& (!name.matches(hdi))) {
			@SuppressWarnings("unused")
			// Creada para añadir a la base de datos
			Observation a;
			a = new Observation(this.time, this.value, this.measure,
					this.indicator, this.area, this.provider, this.publishDate);
		}
		return name;
	}

	@Override
	void processElementCharacters(XMLStreamReader r, String name) {
		if (name.equals("name")) {
			this.setArea(new Area(r.getText(), ScopeEnum.COUNTRY));
		}
		if (name.matches(rangeTime) || name.matches(instantTime)) {
			String value = r.getText();
			obtainMeasure(value);
			this.setValue(value);
		}
	}

	@Override
	String processElementStart(XMLStreamReader r, String name) {
		String newName;
		newName = r.getLocalName();
		// TODO buscar pais en base de datos en vez de crearlo.

		if (newName.matches(rangeTime)) {

			this.setTime(new RangeTime(new InstantTime(newName.split("_")[1]),
					new InstantTime(newName.split("_")[2])));
			this.setIndicator(new Indicator(newName));

		} else if (newName.matches(instantTime)) {

			this.setTime(new InstantTime(newName.split("_")[1]));
			this.setIndicator(new Indicator(newName));

		}
		return newName;
	}

	public void obtainMeasure(String value) {
		if (value.matches(porcent)) {
			this.setMeasure("%");
		} else if (value.matches(unit)) {
			this.setMeasure("u");
		} else {
			this.setMeasure("none");
		}

	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
