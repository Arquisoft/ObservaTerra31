package parser;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import procesadores.ProcesadorLM;

public class ParserUNTest {
	@Test
	public void testXmlCorrecto() throws MalformedURLException, IOException {
		ProcesadorLM procesador = new ProcesadorLM();
		procesador.procesar();
	}
}
