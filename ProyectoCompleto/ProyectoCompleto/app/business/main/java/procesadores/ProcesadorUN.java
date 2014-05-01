package procesadores;

import parser.ParserObservationUN;
import Crawler.UNDownloader;
import domain.Organization;
import domain.SampleOrganization;

/**
 * Clase encargada de llamar al procesador de Observaciones UN para cada documento de esta.
 * @author Victor
 *
 */
public class ProcesadorUN {
	
	public static final Organization UN= new SampleOrganization("United Nations", "", "UN");
	
	public void procesar(){
		for (String archivo: UNDownloader.DOCUMENTS){
			ParserObservationUN parser = new ParserObservationUN(UNDownloader.saveLocation+archivo);
			parser.setProvider(UN);
			parser.parse();
			
		}
	}
}
