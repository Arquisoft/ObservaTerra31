package business.main.java.procesadores;

import business.main.java.parser.ParserObservationLM;
import models.*;

/**
 * Clase encargada de llamar al procesador de Observaciones LM
 * para el documento de esta.
 * @author Victor
 *
 */
public class ProcesadorLM {
	public static final String[] ARCHIVOS={"LM/all.xml"};
	public static final Organization LM = 
			new SampleOrganization("Land Matrix", "", "LM");
	
	public void procesar(){
		for (String archivo: ARCHIVOS){
			ParserObservationLM parser = new ParserObservationLM(archivo);
			parser.setProvider(LM);
			parser.parse();
			
		}
	}
}
