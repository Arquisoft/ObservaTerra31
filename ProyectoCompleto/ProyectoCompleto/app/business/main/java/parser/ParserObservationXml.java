package parser;

import java.io.FileNotFoundException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase abstracta válida para todas las fuentes con observaciones en formato
 * XML.
 * 
 * Realiza toda la lógica de configuración de parseador, dejando la lógica de
 * procesamiento de los elementos a ser implementada por las subclases.
 * 
 * @author Victor
 * 
 */
public abstract class ParserObservationXml extends AbstractParser {

	String filename;
	@SuppressWarnings("unused")
	private DefaultHandler handler;

	public ParserObservationXml(String filename) {
		this.filename = filename;
	}

	/**
	 * Configura el parser para leer el documento como un stream. Entra en un
	 * bucle que continuará hasta que todo el documento haya sido procesado.
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

						name = processElementStart(r, name);

						break;

					case XMLStreamConstants.CHARACTERS:
						processElementCharacters(r, name);

						break;

					case XMLStreamConstants.END_ELEMENT:
						name = processElementEnd(r, name);

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

	/**
	 * Realiza las acciones necesarias tras el fin de una etiqueta XML
	 * 
	 * @param name
	 *            El nombre del elemento XML
	 */
	abstract String processElementEnd(XMLStreamReader r, String name);

	/**
	 * Evalua el contenido textual de una etiqueta XML
	 * 
	 * @param name
	 *            El nombre del elemento XML
	 */
	abstract void processElementCharacters(XMLStreamReader r, String name);

	/**
	 * Realiza las acciones necesarias tras el comienzo de una etiqueta XML
	 * 
	 * @param name
	 *            El nombre del elemento XML
	 */
	abstract String processElementStart(XMLStreamReader r, String name);

}