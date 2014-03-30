import static org.junit.Assert.assertEquals;

import org.junit.Test;

import parser.Parser;
import parser.ParserXml;
import persistence.Observation;
import persistence.Organization;
import persistence.SimpleOrganization;


public class ParserXmlTest {

	@Test
	public void testXmlCorrecto() {
		Parser parser=new ParserXml ("exampleXML.xml");
		parser.setAreaKeyWord("area");
		parser.setCountryKeyWord("country");
		parser.setIndicatorKeyWord("indicator");
		parser.setMeasureKeyWord("measure");
		parser.setObservationKeyWord("data");
		parser.setTimeKeyWord("time");
		parser.setUser("Víctor");
		Organization observaTerra=new SimpleOrganization("ObservaTerra");
		parser.setOrganization(observaTerra);
		
		Observation observation=parser.parse();

		assertEquals("Europe", observation.getArea());
		assertEquals("Spain",observation.getCountry());
		assertEquals("2008",observation.getTime());
		assertEquals("%",observation.getMeasure());
		assertEquals("Sida en niños menores de 5 años",observation.getIndicator());
		assertEquals("1",observation.getData());
		assertEquals("Víctor",observation.getUser());
		assertEquals("ObservaTerra31",observaTerra);
		
	
	}

}
