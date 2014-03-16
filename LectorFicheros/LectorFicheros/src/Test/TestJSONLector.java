package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import LectorJSON.LectorJSON;

public class TestJSONLector {

	private LectorJSON datos;

	@Before
	public void setUp() {}
	
	@Test
	public void testJSON() {
		datos = new LectorJSON("ficheros\\json\\datos.json");
		
		datos.buscarPropiedad("Paro");
		String expected = "espana:\"20%\",alemania:\"4%\"";
		String real = datos.getRespuesta();
		assertTrue( expected.compareTo(real)==0 );
	}
}
