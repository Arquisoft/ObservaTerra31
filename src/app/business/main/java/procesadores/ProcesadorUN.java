package business.main.java.procesadores;

import business.main.java.Crawler.UNDownloader;
import business.main.java.parser.ParserObservationUN;
import models.Organization;
import models.SampleOrganization;

/**
 * Clase encargada de llamar al procesador de Observaciones UN
 * para cada documento de esta.
 * @author Victor
 *
 */
public class ProcesadorUN implements Procesador {
	
	public static final Organization UN = 
			new SampleOrganization("United Nations", 
					"http://hdr.undp.org/en/statistics/hdi", "UN");
	
	@Override
	public void procesar(){
		Organization savedInDataBase = Organization.create(UN);
		for (String archivo: UNDownloader.DOCUMENTS){
			ParserObservationUN parser = 
					new ParserObservationUN(UNDownloader.saveLocation+archivo);
			parser.setProvider(savedInDataBase);
			parser.parse();
		}
	}
	
	@Override
	public Organization getOrganization(){
		return UN;
	}
}
