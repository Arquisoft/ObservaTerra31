import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

@SuppressWarnings("deprecation")
public class IndexMapper extends MapReduceBase implements
		Mapper<Text, Text, Text, Text> {

	/**
	 * Est m�todo recibe una l�nea del fichero le�do.
	 * Por cada palabra de la l�nea escribe en un OutputCollector<Text, Text>
	 * el par <"palabra", "fichero_actual">.
	 * <br/>
	 * No se controla si la "palabra" se repite dentro del mismo fichero.
	 * Ya se encargar� el "IndexReducer" de eliminar repeticiones.
	 * <br/>
	 * Se llamar� a este m�todo varias veces, una por cada l�nea de cada fichero.
	 * Despu�s se llamar� a la clase "IndexReducer"
	 */
	public void map(Text key, Text value, OutputCollector<Text, Text> output,
			Reporter reporter) throws IOException {

		FileSplit fileSplit = (FileSplit) reporter.getInputSplit();
		Path path = fileSplit.getPath();
		String wordPlace = path.getName();
		Text location = new Text(wordPlace);
		String s = key.toString().toLowerCase();

		for (String word : s.split("\\W+")) {
			if (word.length() > 0) {
				output.collect(new Text(word), location);
			}
		}
	}

}
