package Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import LectorCSV.LectorCSV;

public class TestCVSLector {

	private LectorCSV error;
	private LectorCSV error02;
	private LectorCSV correcto;

	@Before
	public void setUp() {}
	
	@Test
	public void testCSVError() {
		error = new LectorCSV("ficheros\\csv\\error.csv");
		error.readFile();
		
		Map<Integer, String> realErrorRows = error.getMapErrorRows();
		Map<Integer, String> realValidRows = error.getMapValidRows();

		// Cantidad de líneas de error = 3
		assertTrue(realErrorRows.size() == 3);

		// Líneas con error: 4, 6, 7 (restando 1: la linea de header)
		List<Integer> expectedErrorRows = new ArrayList<Integer>(Arrays
				.asList(4, 6, 7));
		rowValidator(realErrorRows, expectedErrorRows);

		// Cantidad de líneas válidas (sin contar el header) = 4
		assertTrue(realValidRows.size() == 4);

		// Líneas válidas: 1, 2, 3 y 5 (restando 1: la linea de header)
		List<Integer> expectedValidRows = new ArrayList<Integer>(Arrays.asList(
				1, 2, 3, 5));
		rowValidator(realValidRows, expectedValidRows);
	}
	
	
	@Test
	public void testCSVError02() {
		error02 = new LectorCSV("ficheros\\csv\\error02.csv");
		error02.readFile();
		
		Map<Integer, String> realErrorRows = error02.getMapErrorRows();
		Map<Integer, String> realValidRows = error02.getMapValidRows();

		// Cantidad de líneas de error = 4
		assertTrue(realErrorRows.size() == 4);

		// Líneas con error: 1,3,5
		//(restando 1: la linea de header)
		List<Integer> expectedErrorRows = new ArrayList<Integer>(Arrays
				.asList(1,2,4,6));
		rowValidator(realErrorRows, expectedErrorRows);

		// Cantidad de líneas válidas (sin contar el header) = 2
		assertTrue(realValidRows.size() == 2);

		// Líneas válidas: 3 y 5 (restando 1: la linea de header)
		List<Integer> expectedValidRows = new ArrayList<Integer>(Arrays.asList(
				3, 5));
		rowValidator(realValidRows, expectedValidRows);
	}
	
	
	@Test
	public void testCSVCorrecto() {
		correcto = new LectorCSV("ficheros\\csv\\correcto.csv");
		correcto.readFile();
		
		Map<Integer, String> realErrorRows = correcto.getMapErrorRows();
		Map<Integer, String> realValidRows = correcto.getMapValidRows();

		// Cantidad de líneas de error = 0
		assertTrue(realErrorRows.size() == 0);
		
		// Cantidad de líneas válidas (sin contar el header) = 4
		assertTrue(realValidRows.size() == 4);

		// Líneas válidas: 1, 2, 3 y 4 (restando 1: la linea de header)
		List<Integer> expectedValidRows = new ArrayList<Integer>(Arrays.asList(
				1, 2, 3, 4));
		rowValidator(realValidRows, expectedValidRows);
	}
	
	
	/**
	 * Comprueba la coincidencia entre los valores del Map "realList"
	 * con los del List "expectedList"
	 */
	private void rowValidator(Map<Integer, String> realList,
			List<Integer> expectedList) {
		int indexErrorRow=0;
		for( Integer row : realList.keySet() ){
			assertTrue(expectedList.get(indexErrorRow) == row);
			indexErrorRow++;
		}
	}
}
