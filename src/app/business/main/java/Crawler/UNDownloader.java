package business.main.java.Crawler;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase encargada de descargar todos los archivos con observaciones de la UN.
 * Es un conjunto de archivos fijos por lo que solo necesitará llamarse una vez.
 * 
 * @author Victor
 *
 */
public class UNDownloader {
	
	public final static String[] DOCUMENTS={"wxub-qc5k.xml"
											,"efc4-gjvq.xml"
											,"9jnv-7hyp.xml"
											,"pq34-nwq7.xml"
											,"7p2z-5b33.xml"
											,"7p2z-5b33.xml"
											,"ti85-2nvi.xml"
											,"iv8b-7gbj.xml"
											,"mvtz-nsye.xml"
											,"n9mf-gwye.xml"
											,"itri-v7qr.xml"
											,"3esk-n839.xml"
											,"jixu-gnyy.xml"
											,"ki8j-r4i6.xml"
											,"e6xu-b22v.xml"
	};

	public final static String url= "http://data.undp.org/resource/";
	public final static String saveLocation="public/resources/UN/";
			
	public void download() throws MalformedURLException, IOException{
		for(String document : UNDownloader.DOCUMENTS)
			this.saveUrl(saveLocation + document, url + document );
	}
	private void saveUrl(final String filename, final String urlString)
	        throws MalformedURLException, IOException {
	    BufferedInputStream in = null;
	    FileOutputStream fout = null;
	    try {
	        in = new BufferedInputStream(new URL(urlString).openStream());
	        fout = new FileOutputStream(filename);

	        final byte data[] = new byte[1024];
	        int count;
	        while ((count = in.read(data, 0, 1024)) != -1) {
	            fout.write(data, 0, count);
	        }
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	        if (fout != null) {
	            fout.close();
	        }
	    }
	}
}
