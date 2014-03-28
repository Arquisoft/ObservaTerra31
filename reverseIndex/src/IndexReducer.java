import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

@SuppressWarnings("deprecation")
public class IndexReducer extends MapReduceBase implements
		Reducer<Text, Text, Text, Text> {

	private static final String SEP = ",";

	/**
	 * Este método recibe una palabra ("key") y una lista de Text ("values")
	 * que contiene los nombres de todos los ficheros que la contienen.
	 * <br/>
	 * Escribe en un OutputCollector<Text, Text> un par del tipo:
	 * <"palabra", "todos_los_ficheros_que_la_contienen">
	 */
	@Override
	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {

		StringBuilder valueList = new StringBuilder();

		String currentValue = "";
		while (values.hasNext()) {

			currentValue = values.next().toString();
			if (!valueList.toString().contains(currentValue)) {
				valueList.append(currentValue);
				valueList.append(SEP);
			}
		}
		// delete last separator:
		valueList.deleteCharAt(valueList.length() - 1);
		output.collect(key, new Text(valueList.toString()));
	}

}
