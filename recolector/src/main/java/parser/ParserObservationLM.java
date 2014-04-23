package parser;

import java.util.regex.*;

import javax.xml.stream.XMLStreamReader;
import domain.Area;
import domain.Indicator;
import domain.InstantTime;
import domain.Observation;
import domain.ScopeEnum;

public class ParserObservationLM extends ParserObservationXml {
	Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9]");
	StringBuilder stringBuilder = new StringBuilder();

	public ParserObservationLM(String filename) {
		super(filename);
	}

	/*
	 * Parsea el docuento XML que se le haya aÃ±adido,pasando por todos
	 * elementos del arbol
	 */

	@Override
	String processElementEnd(XMLStreamReader r, String name) {
		String newName;
		newName = r.getLocalName();
		if (newName.equals("item")) {
			@SuppressWarnings("unused")
			Observation a;
			this.value = stringBuilder.toString();
			a = new Observation(this.time, this.value, this.measure,
					this.indicator, this.area, this.provider, this.publishDate);
			stringBuilder = new StringBuilder();

		}
		return newName;
	}

	@Override
	void processElementCharacters(XMLStreamReader r, String name) {
		if (name.equals("negotiation_status")) {
			Matcher matcher = pattern.matcher(r.getText());
			if (matcher.find()) {
				this.setTime(new InstantTime(matcher.group(0)));
			}
		}

		if (name.equals("target_country")) {
			String textoArea = r.getText();
			this.setArea(new Area(textoArea.replaceAll("[\n\t]", ""),
					ScopeEnum.COUNTRY));
		} else if (name.equals("intention")) {
			String textoIndicator = r.getText();
			this.setIndicator(new Indicator("Deal of "
					+ textoIndicator.replaceAll("[\n\t]", "")));
		} else if (name != "") {
			String texto = r.getText();
			stringBuilder.append("Field: " + name + "Data:"
					+ texto.replaceAll("[\n\t]", "") + "\n");
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
		// TODO buscar pais en base de datos en vez de crearlo.
		return newName;
	}

}
