package Crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
    public static void main(String[] args) throws Exception {
            String crawlStorageFolder = "/data/crawl/root";
            int numberOfCrawlers = 7;

            CrawlConfig config = new CrawlConfig();
            config.setCrawlStorageFolder(crawlStorageFolder);

            /*
             * Se crea una instancia del controlador para
			 * este crawler
             */
            PageFetcher pageFetcher = new PageFetcher(config);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            /*
             * Se añaden las paginas que queramos que visite el crawler. 
             */
            controller.addSeed("http://data.undp.org/resource/wxub-qc5k.xml");
            controller.addSeed("http://data.undp.org/resource/efc4-gjvq.xml");
            controller.addSeed("http://data.undp.org/resource/9jnv-7hyp.xml");
            controller.addSeed("http://data.undp.org/resource/pq34-nwq7.xml");
            controller.addSeed("http://data.undp.org/resource/7p2z-5b33.xml");
            controller.addSeed("http://data.undp.org/resource/ti85-2nvi.xml");
            controller.addSeed("http://data.undp.org/resource/iv8b-7gbj.xml");
            controller.addSeed("http://data.undp.org/resource/mvtz-nsye.xml");
            controller.addSeed("http://data.undp.org/resource/n9mf-gwye.xml");
            controller.addSeed("http://data.undp.org/resource/itri-v7qr.xml");
            controller.addSeed("http://data.undp.org/resource/3esk-n839.xml");
            controller.addSeed("http://data.undp.org/resource/jixu-gnyy.xml");
            controller.addSeed("http://data.undp.org/resource/ki8j-r4i6.xml");
            controller.addSeed("http://data.undp.org/resource/e6xu-b22v.xml");

            /*
             * El crawler comienza a funcionar.Este método es bloqueante,por lo que el resto
			 * del código no se ejecuta hasta que finalice.
             */
            controller.start(Crawler.class, numberOfCrawlers);    
    }
}
