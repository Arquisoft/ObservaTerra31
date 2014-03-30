package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.helpers.DefaultHandler;

public class ParserXml extends AbstractParser {
	
	private String filename;
	@SuppressWarnings("unused")
	private DefaultHandler handler;
	public ParserXml(String filename) {
		this.filename=filename;
	
		 		
	}
	
	/*
	 * Parsea el docuento XML que se le haya añadido,pasando por todos
	 * elementos del arbol
	 */
	@Override
	public void parseDocument() {
		
		 try {
	            XMLInputFactory xmlif = XMLInputFactory.newInstance();
	            xmlif.setProperty(
	                    XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,
	                    Boolean.TRUE);
	            xmlif.setProperty(
	                    XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
	                    Boolean.FALSE);
	            //set the IS_COALESCING property to true 
	            //to get whole text data as one event.           
	            xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
	            
	            try {
	                XMLEventReader r = null;
	                URL xmlFileURL = getClass().getClassLoader().getResource(filename);
	                if (xmlFileURL != null) {
	                    r = xmlif.createXMLEventReader(
	                            filename,
	                            new FileInputStream(new File(xmlFileURL.toURI())));
	                } else throw new FileNotFoundException();
	                
	              // Se continua ejecutando siempre que haya elementos dentro del arbol
	                while (r.hasNext()) {
	                    XMLEvent e = r.nextEvent();
	                    if (e.isStartElement()) {
	                        if (hasStartTagName(e, this.getAreaKeyWord() )) {
	                           this.setArea(getCharacters(r));
	                        }
	                        else if (hasStartTagName(e, this.getCountryKeyWord())) {
	                            this.setCountry(getCharacters(r)); 
	                        }
	                        else if (hasStartTagName(e, this.getIndicatorKeyWord())) {
	                        	this.setIndicator(getCharacters(r));  
	                        }
	                        else if (hasStartTagName(e, this.getMeasureKeyWord())) {
	                        	this.setMeasure(getCharacters(r));  
	                        }
	                        else if (hasStartTagName(e, this.getDataKeyWord())) {
	                        	this.setData(getCharacters(r));  
	                        }
	                        else if (hasStartTagName(e, this.getTimeKeyWord())) {
	                        	this.setTime(getCharacters(r)); 
	                        }
	                    }
	                }
	            } catch (XMLStreamException ex) {
	                System.out.println(ex.getMessage());

	                if (ex.getNestedException() != null) {
	                    ex.getNestedException().printStackTrace();
	                }
	            }            
	        
	        } catch (FileNotFoundException ex) {
	            System.err.println("Error.  Cannot find \"" + filename + "\" in classpath.");
	            ex.printStackTrace();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		 
		 
		 
	}
	
	/* 
	 * Devuelve los datos existentes (en el caso de que los haya) dentro
	 * del elemento
	 * @param rdr
	 * @return e.asCharacters().getData() o null
	 */
    
    private String getCharacters(XMLEventReader rdr) throws XMLStreamException {
        XMLEvent e = rdr.nextEvent();
        if (e.isCharacters()) {
            return e.asCharacters().getData(); 
        } else {
            return null;
        }
    }
    
    private boolean hasStartTagName(XMLEvent e, String name) {
        return e.asStartElement().getName().getLocalPart().equals(name);
    }
    

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
