import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CSVDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		final SparkSession sparkSession = SparkSession.builder().appName("Spark CSV Analysis Demo").master("local[5]")
				.getOrCreate();
		final Dataset<Row> csvDataFrame =sparkSession.read().format("csv").option("header", "true").load("src/main/resources/data.csv");
		csvDataFrame.printSchema();
		csvDataFrame.show();
		csvDataFrame.createGlobalTempView("sita");
		
		sparkSession.sql("select * from global_temp.sita").show();;
		
	}

}
