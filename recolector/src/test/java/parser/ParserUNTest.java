package parser;

import org.junit.Test;

import procesadores.ProcesadorUN;

public class ParserUNTest {
	@Test
	public void testXmlCorrecto() {
		ProcesadorUN procesador = new ProcesadorUN();
		procesador.procesar();

	}
}
