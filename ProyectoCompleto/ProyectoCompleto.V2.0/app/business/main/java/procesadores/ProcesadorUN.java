package business.main.java.procesadores;

import models.Organization;
import models.SampleOrganization;
import business.main.java.Crawler.UNDownloader;
import business.main.java.parser.ParserObservationUN;

/**
 * Clase encargada de llamar al procesador de Observaciones UN
 * para cada documento de esta.
 * @author Victor
 *
 */
public class ProcesadorUN {
	
	public static final Organization UN = 
			new SampleOrganization("United Nations", "", "UN");
	
	public static void procesar(){
		
		System.out.println(
				"\nData are being processed. Please, wait. " +
				"\nThis may take about two minutes...");
		
		Organization.create(UN);
		
		for (String archivo: UNDownloader.DOCUMENTS){
			ParserObservationUN parser = 
					new ParserObservationUN(UNDownloader.saveLocation+archivo);
			parser.setProvider(UN);
			parser.parse();
		}
		
		System.out.println(
				"\nFinish. Data have been inserted in data base.");
	}
}
