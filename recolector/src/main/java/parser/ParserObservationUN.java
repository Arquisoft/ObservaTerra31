package parser;

import java.io.FileNotFoundException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.helpers.DefaultHandler;

import domain.Area;
import domain.Indicator;
import domain.InstantTime;
import domain.Observation;
import domain.RangeTime;
import domain.ScopeEnum;

public class ParserObservationUN extends AbstractParser {
	private String rangeTime = "_[0-9][0-9][0-9][0-9]_[0-9][0-9][0-9][0-9].+";
	private String instantTime = "_[0-9][0-9][0-9][0-9].+";
	private String hdi = "_[0-9][0-9][0-9][0-9]_hdi.+";
	private String filename;
	@SuppressWarnings("unused")
	private DefaultHandler handler;

	public ParserObservationUN(String filename) {
		this.filename = filename;

	}

	/*
	 * Parsea el docuento XML que se le haya añadido,pasando por todos elementos
	 * del arbol
	 */
	public void parse() {

		try {
			XMLInputFactory xmlif = XMLInputFactory.newInstance();
			xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,
					Boolean.TRUE);
			xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
					Boolean.FALSE);
			// set the IS_COALESCING property to true
			// to get whole text data as one event.
			xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);

			try {
				XMLStreamReader r = null;
				URL xmlFileURL = getClass().getClassLoader().getResource(
						filename);
				if (xmlFileURL != null) {
					XMLInputFactory factory = XMLInputFactory.newInstance();
					r = factory.createXMLStreamReader(ClassLoader
							.getSystemResourceAsStream(filename));

				} else
					throw new FileNotFoundException();

				// Se continua ejecutando siempre que haya elementos dentro del
				// arbol
				String name = "";
				while (r.hasNext()) {
					int event = r.next();
					
					switch (event) {

					case XMLStreamConstants.START_ELEMENT:

						name = r.getLocalName();
						// TODO buscar pais en base de datos en vez de crearlo.
						
						if (name.matches(rangeTime)) {

							this.setTime(new RangeTime(new InstantTime(name
									.split("_")[1]),
									new InstantTime(name
											.split("_")[2])));
							this.setIndicator(new Indicator(name));

						} else if (name.matches(instantTime)) {

							this.setTime(new InstantTime(name
									.split("_")[1]));
							this.setIndicator(new Indicator(name));

						}

						break;

					case XMLStreamConstants.CHARACTERS:
						if (name.equals("name")) {
							this.setArea(new Area(r.getText(),
									ScopeEnum.COUNTRY));
						}
						if (name.matches(rangeTime)
								|| name.matches(instantTime))
							this.setValue(r.getText());

						break;

					case XMLStreamConstants.END_ELEMENT:
						if (name.matches(rangeTime)
								|| name.matches(instantTime)&&(!name.matches(hdi))){
							Observation a;
							a=new Observation(this.time, this.value,
									this.measure, this.indicator, this.area,
									this.provider, this.publishDate);
							}

						break;

					case XMLStreamConstants.START_DOCUMENT:

						break;

					}

				}

			} catch (XMLStreamException ex) {
				System.out.println(ex.getMessage());

				if (ex.getNestedException() != null) {
					ex.getNestedException().printStackTrace();
				}
			}

		} catch (FileNotFoundException ex) {
			System.err.println("Error.  Cannot find \"" + filename
					+ "\" in classpath.");
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
