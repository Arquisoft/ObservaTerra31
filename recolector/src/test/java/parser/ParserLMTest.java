package parser;

import org.junit.Test;

import procesadores.ProcesadorLM;


public class ParserLMTest {
	@Test
	public void testXmlCorrecto() {
		ProcesadorLM procesador = new ProcesadorLM();
		procesador.procesar();
	}
}
