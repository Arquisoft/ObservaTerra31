package procesadores;

import parser.ParserObservationLM;
import domain.*;

public class ProcesadorLM {
	public static final String[] ARCHIVOS={"all.xml"};
	public static final Organization LM= new SampleOrganization("Land Matrix", "", "LM");
	
	public void procesar(){
		for (String archivo: ARCHIVOS){
			ParserObservationLM parser = new ParserObservationLM(archivo);
			parser.setProvider(LM);
			parser.parse();
			
		}
	}
}
