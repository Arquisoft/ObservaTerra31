package business.main.java.procesadores;

import business.main.java.parser.ParserObservationLM;
import models.*;

/**
 * Clase encargada de llamar al procesador de Observaciones LM
 * para el documento de esta.
 * @author Victor
 *
 */
public class ProcesadorLM implements Procesador {
	
	public static final String[] ARCHIVOS={"public/resources/LM/all.xml"};
	public static final Organization LM = 
			new SampleOrganization("Land Matrix", 
					"http://landmatrix.org/en/", "LM");
	
	@Override
	public void procesar(){
		Organization.create(LM);
		for (String archivo: ARCHIVOS){
			ParserObservationLM parser = new ParserObservationLM(archivo);
			parser.setProvider(LM);
			parser.parse();
		}
	}
	
	@Override
	public Organization getOrganization(){
		return LM;
	}
}
