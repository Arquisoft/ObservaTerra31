package LectorCSV;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LectorCSV {

	private static final String ERROR_HEADER_LINEBREAK =
		"La cabecera contiene caracteres no textuales" +
		"(salto de l�nea, retorno de carro, tabulaci�n, etc.)";
	private static final String ERROR_ROW_LINEBREAK =
		"La l�nea contiene caracteres no textuales" +
		"(salto de l�nea, retorno de carro, tabulaci�n, etc.)";
	private static final String ERROR_ROW_NUMBERFIELDS =
		"La cantidad de campos de esta l�nea no coincide" +
		"con la cabecera";
	
	private String nameFile;
	private Map<Integer, String> mapValidRows = new HashMap<Integer, String>();
	private Map<Integer, String> mapErrorRows = new HashMap<Integer, String>();
	private int rowsCounter;
	private int numberOfHeaders;
	
	public LectorCSV(String nFile){
		nameFile = nFile;
		rowsCounter = 0;
	}
	
	/**
	 * Lee un fichero .CSV, y separa las l�nes v�lidas y las err�neas
	 * en sendas listas
	 */
	public void readFile() {
		BufferedReader fichero;
		try {
			fichero = new BufferedReader(new FileReader(nameFile));
			String linea = fichero.readLine();
			numberOfHeaders = numberOfHeaders(linea);
			
			if( numberOfHeaders != -1 ){
				while((linea = fichero.readLine()) != null) {
					rowsCounter++;
					String lineaUTF8 = new String(linea.getBytes(),"UTF-8");
					if( !errorRow(lineaUTF8) ){
						mapValidRows.put(rowsCounter, lineaUTF8);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Cantidad de campos que tiene la cabecera (primera l�nea del CSV)
	 * <br/> Devuelve -1 si se detecta que la cabecera no est� en el formato adecuado.
	 */
	private int numberOfHeaders(String lineaHeader) throws IOException {
		// La expresi�n ",[^ ]" separa el String por comas...
		// salvo cuando la coma est� seguida de un espacio en blanco.
		// En este �ltimo caso, se considera que la coma forma parte de un texto
		
		String lineaHeaderUTF8 = new String(lineaHeader.getBytes(),"UTF-8");
		String[] camposHeader = lineaHeaderUTF8.split(",[^ ]");
		
		if( lineaHeaderUTF8.contains("\n")
				|| lineaHeaderUTF8.contains("\r")
				|| lineaHeaderUTF8.contains("\t")
				|| lineaHeaderUTF8.contains("\f") ){
			mapErrorRows.put(rowsCounter, ERROR_HEADER_LINEBREAK);
			return -1;
		}
		return camposHeader.length;
	}
	
	/**
	 * @return true: cuando se detecta que la l�nea no est� en el
	 * formato adecuado:<ul>
	 * <li>cuando el n�mero de campos de la l�nea recibida
	 * no coincide con el de la cabecera (primera l�nea del CSV)</li>
	 * <li>cuando la l�nea contiene caracteres no textuales
	 * (tabulaciones, etc.)</li></ul>
	 */
	private boolean errorRow(String linea) throws IOException {
		// La expresi�n ",[^ ]" separa el String por comas...
		// salvo cuando la coma est� seguida de un espacio en blanco.
		// En este �ltimo caso, se considera que la coma forma parte de un texto
		
		String lineaUTF8 = new String(linea.getBytes(),"UTF-8");
		String[] camposLinea = lineaUTF8.split(",[^ ]");
		int numberOfCols = camposLinea.length;
		
		if( numberOfCols != numberOfHeaders ){
			mapErrorRows.put(rowsCounter, ERROR_ROW_NUMBERFIELDS);
			return true;
		}
		if( lineaUTF8.contains("\n") || lineaUTF8.contains("\r")
				|| lineaUTF8.contains("\t") || lineaUTF8.contains("\f") ){
			mapErrorRows.put(rowsCounter, ERROR_ROW_LINEBREAK);
			return true;
		}
		return false;
	}
	
	
	/*
	private void printValidRows() {
		for( Integer row : mapValidRows.keySet() ){
			System.out.println( mapValidRows.get(row) );
		}
	}
	*/

	// GETTERS & SETTERS //
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public int getRowsCounter() {
		return rowsCounter;
	}
	public Map<Integer, String> getMapValidRows() {
		return mapValidRows;
	}
	public Map<Integer, String> getMapErrorRows() {
		return mapErrorRows;
	}
}