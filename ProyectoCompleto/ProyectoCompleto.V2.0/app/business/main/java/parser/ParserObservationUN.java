package business.main.java.parser;

import java.util.Date;

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
	private String range = "_[0-9][0-9][0-9][0-9]_[0-9][0-9][0-9][0-9]";
	// Expresion regular del formato de los InstantTime en las observaciones de
	// la UN.
	private String instantTime = "_[0-9][0-9][0-9][0-9].+";
	private String instant = "_[0-9][0-9][0-9][0-9]";
	private String hdi = "_[0-9][0-9][0-9][0-9]_hdi.+";
	private String porcent = "0.[0-9]+";
	private String unit = "[0-9]+[0-9].[0-9]*";
	private String unitUnaUnidad= "[1-9].[0-9]+";
	private String unkownCodeLetter= "[a-z]";

	public ParserObservationUN(String filename) {
		super(filename);
		this.publishDate=new Date();
	}

	@Override
	String processElementEnd(XMLStreamReader r, String name) {
		if (name.matches(rangeTime) || name.matches(instantTime)
				&& (!name.matches(hdi))
				&& !this.value.matches(unkownCodeLetter)) {
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
			createArea(areaName, scope);
		}
		if (name.matches(rangeTime) || name.matches(instantTime)){
			value = r.getText();
		    obtainMeasure(value);
		}
	}

	@Override
	String processElementStart(XMLStreamReader r, String name) {
		String newName = r.getLocalName();

		if (newName.matches(rangeTime)) {
			String instantStart = newName.split("_")[1];
			String instantEnd = newName.split("_")[2];
			createRangedTime(instantStart, instantEnd);
			
			String indName = newName.replaceFirst(range, "").replace('_', ' ');
			createIndicator(indName);

		} else if (newName.matches(instantTime)) {
			String timeInstant = newName.split("_")[1];
			createInstantTime(timeInstant);
			
			String indName = newName.replaceFirst(instant, "").replace('_', ' ');
			createIndicator(indName);
		}
		return newName;
	}
	
	private void obtainMeasure(String value) {
		if (value.matches(porcent)) {
			if(value.contains("-")) value.split("-");
			this.setMeasure("%");
			this.setValue(value);
		} else if (value.matches(unit) || value.matches(unitUnaUnidad)) {
			if(value.contains("-")) value.split("-");
			this.setMeasure("units");
			this.setValue(value);
		}else{
			this.setMeasure("none");
			this.setValue(value);
		}
	}
	
	private void createArea(String areaName, ScopeEnum scope) {
		Area area = new Area(areaName, scope);
		area.setId((long) Area.all().size() + 1);
		area = Area.create(area);
		this.setArea(area);
	}
	
	private void createInstantTime(String timeInstant) {
		InstantTime time = new InstantTime(timeInstant);
		time = (InstantTime) time.create(time);
		this.setTime(time);
	}
	
	private void createRangedTime(String instantStart, String instantEnd) {
		// Crear e insertar los InstantTime start y end
		InstantTime timeStart = new InstantTime(instantStart);
		InstantTime timeEnd = new InstantTime(instantEnd);
		timeStart = (InstantTime) timeStart.create(timeStart);
		timeEnd = (InstantTime) timeEnd.create(timeEnd);

		// Crear e insertar el RangeTime a partir de susodichos InstantTime
		RangeTime newRangeTime = new RangeTime(timeStart, timeEnd);
		newRangeTime = (RangeTime) newRangeTime.create(newRangeTime);
		this.setTime(newRangeTime);
	}
	
	private void createIndicator(String indicatorName) {
		Indicator ind = new Indicator(indicatorName);
		ind = Indicator.create(ind);
		this.setIndicator(ind);
	}
}
