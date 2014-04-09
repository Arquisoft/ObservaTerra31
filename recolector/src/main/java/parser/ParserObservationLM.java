package parser;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.regex.*;

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

public class ParserObservationLM extends AbstractParser {
	Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9]");
	StringBuilder stringBuilder =  new StringBuilder();
	
	
	private String filename;
	@SuppressWarnings("unused")
	private DefaultHandler handler;

	public ParserObservationLM(String filename) {
		this.filename = filename;

	}

	/*
	 * Parsea el docuento XML que se le haya a�adido,pasando por todos elementos
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
                       if(r.getAttributeCount()>0){
						name = r.getAttributeValue(0);
                       }else {
                    	   name="";
                       }
						// TODO buscar pais en base de datos en vez de crearlo.
					
						

						break;

					case XMLStreamConstants.CHARACTERS:
						
						
						if(name.equals("negotiation_status")){
							Matcher matcher = pattern.matcher(r.getText());
							if(matcher.find()){
							this.setTime(new InstantTime(matcher.group(0)));
							}
						}
							
							
								if (name.equals("target_country")) {
									this.setArea(new Area(r.getText(),
											ScopeEnum.COUNTRY));
								} else if(name.equals("intention")){
								this.setIndicator(new Indicator("Deal of " + r.getText()));
								} else if(name!=""){
					    	 stringBuilder.append("Field: " + name + "Data:" + r.getText()+ "\n");
						}
						

						break;

					case XMLStreamConstants.END_ELEMENT:
						name=r.getLocalName();
						if (name.equals("item")){
							Observation a;
							this.value= stringBuilder.toString();
							a=new Observation(this.time, this.value,
									this.measure, this.indicator, this.area,
									this.provider, this.publishDate);
							stringBuilder= new StringBuilder();
							System.out.println(a.toString());
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
