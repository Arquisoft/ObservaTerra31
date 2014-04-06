package procesadores;

import parser.ParserObservationUN;
import domain.*;

public class ProcesadorUN {
	public static final String[] ARCHIVOS={"e6xu-b22v.xml"};
	public static final Organization UN= new SampleOrganization("United Nations", "", "UN");
	
	public void procesar(){
		for (String archivo: ARCHIVOS){
			ParserObservationUN parser = new ParserObservationUN(archivo);
			parser.setProvider(UN);
			parser.parse();
			
		}
	}
}
