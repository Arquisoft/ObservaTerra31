package parser;

import static org.junit.Assert.*;

import org.junit.Test;

import parser.Parser;
import parser.ParserXml;
import persistence.Observation;
import persistence.Organization;
import persistence.SimpleOrganization;

public class ParserJsonTest {

	@Test
	public void testXmlCorrecto() {
		Parser parser = new ParserJson("src/test/resources/exampleJSON.json");
		parser.setAreaKeyWord("area");
		parser.setCountryKeyWord("country");
		parser.setIndicatorKeyWord("indicator");
		parser.setMeasureKeyWord("measure");
		parser.setObservationKeyWord("data");
		parser.setTimeKeyWord("time");
		parser.setUser("Víctor");
		Organization observaTerra = new SimpleOrganization("ObservaTerra");
		parser.setOrganization(observaTerra);

		Observation observation = parser.parse();

		assertEquals("Europe", observation.getArea());
		assertEquals("Spain", observation.getCountry());
		assertEquals("2008", observation.getTime());
		assertEquals("%", observation.getMeasure());
		assertEquals("Sida en niños menores de 5 años",
				observation.getIndicator());
		assertEquals("1", observation.getData());
		assertEquals("Víctor", observation.getUser());
		assertEquals(observaTerra, observation.getOrganization());

	}

	@Test(expected = IllegalStateException.class)
	public void testXmlMalConfigurado() {
		Parser parser = new ParserJson("exampleJSON.json");
		parser.setAreaKeyWord("area");
		parser.setCountryKeyWord("country");
		parser.setIndicatorKeyWord("i");// No concuerda con el fichero xml.
		parser.setMeasureKeyWord("measure");
		parser.setObservationKeyWord("data");
		parser.setTimeKeyWord("time");
		parser.setUser("Víctor");
		Organization observaTerra = new SimpleOrganization("ObservaTerra");
		parser.setOrganization(observaTerra);
		parser.parse();

		

	}

	@Test(expected = IllegalStateException.class)
	public void testXmlInCorrecto() {
		Parser parser = new ParserJson("exampleJSONIncorrecto.json");
		parser.setAreaKeyWord("area");
		parser.setCountryKeyWord("country");
		parser.setIndicatorKeyWord("indicator");
		parser.setMeasureKeyWord("measure");
		parser.setObservationKeyWord("data");
		parser.setTimeKeyWord("time");
		parser.setUser("Víctor");
		Organization observaTerra = new SimpleOrganization("ObservaTerra");
		parser.setOrganization(observaTerra);

		parser.parse();

	}

}
