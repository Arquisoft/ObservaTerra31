package business.main.java.parser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

import javax.xml.stream.XMLStreamReader;
import models.*;
import models.types.*;

public class ParserObservationLM extends ParserObservationXml {
	Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9]");
	private Map<String,String> valuesOfElement = new HashMap<String,String>();

	public ParserObservationLM(String filename) {
		super(filename);
		this.publishDate=new Date();
	}

	@Override
	String processElementEnd(XMLStreamReader r, String name) {
		String newName;
		newName = r.getLocalName();
		
		if (newName.equals("item")) {
			Observation obs;
			for (String value : valuesOfElement.keySet()) {
				this.setValue(value);
				this.setMeasure(valuesOfElement.get(value));
				obs = new Observation(this.time, this.value, this.measure,
					this.indicator, this.area, this.provider, this.publishDate);
				Observation.create(obs);
			}
			valuesOfElement.clear();
		}
		return newName;
	}

	@Override
	void processElementCharacters(XMLStreamReader r, String name) {
		if (name.equals("negotiation_status")) {
			Matcher matcher = pattern.matcher(r.getText());
			if (matcher.find()) {
				String instant = matcher.group(0);
				createInstantTime(instant);
			}
		
		} else if (name.equals("target_country")) {
			String textoArea = r.getText().replaceAll("[\n\t]", "");
			createArea(textoArea);
			
		} else if (name.equals("intention")) {
			String textoIndicator = r.getText().replaceAll("[\n\t]", "");
			createIndicator(textoIndicator);
		
		} else if (name.equals("production_size") 
				|| name.equals("contract_size")
				|| name.equals("intended_size")) {
			String value = r.getText().replaceAll("[\n\t]", "");
			if( value.compareToIgnoreCase("None")!=0 ){
				valuesOfElement.put(value, name);
			}
		}
	}

	@Override
	String processElementStart(XMLStreamReader r, String name) {
		String newName;
		if (r.getAttributeCount() > 0) {
			newName = r.getAttributeValue(0);
		} else {
			newName = "";
		}
		return newName;
	}
	
	private void createArea(String textoArea) {
		Area area = new Area(textoArea, ScopeEnum.COUNTRY);
		area.setId((long) Area.all().size() + 1);
		area = Area.create(area);
		this.setArea(area);
	}
	
	private void createInstantTime(String instant) {
		InstantTime time = new InstantTime(instant);
		time = (InstantTime) time.create(time);
		this.setTime(time);
	}
	
	private void createIndicator(String indicatorText) {
		Indicator ind = new Indicator("Deal of " + indicatorText);
		ind = Indicator.create(ind);
		this.setIndicator(ind);
	}
}
