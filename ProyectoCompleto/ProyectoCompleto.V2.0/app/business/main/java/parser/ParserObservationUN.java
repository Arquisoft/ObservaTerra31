package business.main.java.parser;

import javax.xml.stream.XMLStreamReader;

import models.Area;
import models.Indicator;
import models.InstantTime;
import models.Observation;
import models.RangeTime;
import models.types.ScopeEnum;

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
	private String porcent = "0.[0-9]+";
	private String unit = "[0-9]+[0-9].[0-9]*";
	private String unitUnaUnidad= "[1-9].[0-9]+";

	public ParserObservationUN(String filename) {
		super(filename);
	}

	@Override
	String processElementEnd(XMLStreamReader r, String name) {
		if (name.matches(rangeTime) || name.matches(instantTime)
				&& (!name.matches(hdi))) {
			Observation obs;
			obs = new Observation(this.time, this.value, this.measure,
					this.indicator, this.area, this.provider, this.publishDate);
			Observation.create(obs);
		}
		return name;
	}

	@Override
	void processElementCharacters(XMLStreamReader r, String name) {
		if (name.equals("name") || name.equals("country_name")) {

			String areaName = r.getText();
			ScopeEnum scope = ScopeEnum.COUNTRY;

			Area area = new Area(areaName, scope);
			area.setId((long) Area.all().size() + 1);
			
			// Intenta insertar el Area. Si ya existia (== null),
			// la variable area tomara el valor de la que ya existia
			if (Area.create(area) == null)
				area = Area.findByNameScope(areaName, scope);
			this.setArea(area);
		}
		if (name.matches(rangeTime) || name.matches(instantTime)){
			value = r.getText();
		    obtainMeasure(value);
		}
	}

	@Override
	String processElementStart(XMLStreamReader r, String name) {
		String newName;
		newName = r.getLocalName();

		if (newName.matches(rangeTime)) {

			String instantStart = newName.split("_")[1];
			String instantEnd = newName.split("_")[2];

			InstantTime timeStart = new InstantTime(instantStart);
			InstantTime timeEnd = new InstantTime(instantEnd);

			// Intenta insertar el timeStart. Si ya existia (== null),
			// la variable timeStart tomara el valor del que ya existia
			if (timeStart.create(timeStart) == null)
				timeStart = (InstantTime) timeStart.findByInstant(instantStart);

			// Intenta insertar el timeEnd. Si ya existia (== null),
			// la variable timeEnd tomara el valor del que ya existia
			if (timeEnd.create(timeEnd) == null)
				timeEnd = (InstantTime) timeEnd.findByInstant(instantEnd);

			RangeTime newRangeTime = new RangeTime(timeStart, timeEnd);
			// Intenta insertar el newRangeTime. Si ya existia (== null),
			// la variable newRangeTime tomara el valor del que ya existia
			if( newRangeTime.create(newRangeTime) == null )
				newRangeTime = 
					(RangeTime) newRangeTime.findByRange(timeStart, timeEnd);
			this.setTime(newRangeTime);

			Indicator ind = new Indicator(newName);
			// Intenta insertar el Indicator. Si ya existia (== null),
			// la variable ind tomara el valor del que ya existia
			if (Indicator.create(ind) == null) {
				ind = Indicator.findByName(newName);
			}
			this.setIndicator(ind);

		} else if (newName.matches(instantTime)) {
			String timeInstant = newName.split("_")[1];
			InstantTime time = new InstantTime(timeInstant);
			// Intenta insertar el time. Si ya existia (== null),
			// la variable time tomara el valor del que ya existia
			if (time.create(time) == null)
				time = (InstantTime) time.findByInstant(timeInstant);
			this.setTime(time);
			
			Indicator ind = new Indicator(newName);
			// Intenta insertar el Indicator. Si ya existia (== null),
			// la variable ind tomara el valor del que ya existia
			if (Indicator.create(ind) == null) {
				ind = Indicator.findByName(newName);
			}
			this.setIndicator(ind);
		}
		return newName;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public void obtainMeasure(String value) {
		if (value.matches(porcent)) {
			if(value.contains("-")){
			value.split("-");
			}
			this.setMeasure("%");
			this.setValue(value);
		} else if (value.matches(unit) || value.matches(unitUnaUnidad)) {
			if(value.contains("-")){
			value.split("-");
			}
			this.setMeasure("u");
			this.setValue(value);
		}else{
			this.setMeasure("none");
			this.setValue(value);
		}

	}
}
