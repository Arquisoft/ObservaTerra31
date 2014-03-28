import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileAlreadyExistsException;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.InvalidInputException;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.KeyValueTextInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

@SuppressWarnings("deprecation")
public class InvertedIndex extends Configured implements Tool {

	@SuppressWarnings("static-access")
	@Override
	public int run(String[] args) throws Exception {
		String input = "";
		String output = "";
		if (args.length == 2) {
			input = args[0];
			output = args[1];
		} else {
			System.err.println("Please, choose two directories for input "
					+ "and output files");
			System.exit(0);
		}

		JobClient client = new JobClient();
		JobConf conf = new JobConf(getConf(), InvertedIndex.class);
		conf.setJobName(this.getClass().getName());

		conf.setMapperClass(IndexMapper.class);
		conf.setReducerClass(IndexReducer.class);
		
		conf.setInputFormat(KeyValueTextInputFormat.class);

		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(conf, new Path(input));
		FileOutputFormat.setOutputPath(conf, new Path(output));
		
		client.setConf(conf);
		try{
			client.runJob(conf);
		}catch (InvalidInputException e ){
			System.err.println("Input directory is not available: " + input);
		}catch (FileAlreadyExistsException e ){
			System.err.println("Output directory already exists: " + output);
		}
		
		return 0;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new InvertedIndex(), args);
		System.exit(exitCode);
	}

}
