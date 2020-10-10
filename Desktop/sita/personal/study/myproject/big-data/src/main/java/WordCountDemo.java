import java.util.*;

import org.apache.spark.*;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class WordCountDemo {

	public static void main(String[] args) {
		
		 System.setProperty("hadoop.home.dir", "C:\\winutil\\");
		 System.out.println(System.getenv("SPARK_HOME"));
		// Prepare the spark configuration by setting application name and master node "local" i.e. embedded mode
		final SparkConf sparkConf = new SparkConf().setAppName("Word Count Demo").setMaster("local");
		
		try(final JavaSparkContext jSC = new JavaSparkContext(sparkConf)) {
			// Create list of sentences
			final List<String> sentences = Arrays.asList(
					"All Programming Tutorials",
					"Getting Started With Apache Spark",
					"Developing Java Applications In Apache Spark",
					"Getting Started With RDDs In Apache Spark"
			);
			// Split the sentences into words, convert words to key, value with key as word and value 1, 
			// and finally count the occurrences of a word
//			final Map<String, Object> wordsCount = jSC.parallelize(sentences).flatMap((x)->  Arrays.asList(x.split(" ")))
//			  .mapToPair((x) -> new Tuple2<String, Integer>(x, 1)).countByKey();
//													;
//					
//			
//			System.out.println(wordsCount);
		}		
	}

}
