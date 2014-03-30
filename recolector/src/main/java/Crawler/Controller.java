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
            controller.addSeed("http://www.landmatrix.org/es/get-the-detail/database.csv");
           
            /*
             * El crawler comienza a funcionar.Este método es bloqueante,por lo que el resto
			 * del código no se ejecuta hasta que finalice.
             */
            controller.start(Crawler.class, numberOfCrawlers);    
    }
}
