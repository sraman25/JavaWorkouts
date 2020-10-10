import org.apache.spark.sql.SparkSession;

public class SparkCluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SparkSession sparkSession = SparkSession.builder().appName("myspark")
				.master("yarn")
				.config("spark.hadoop.fs.defaultFS","hdfs://192.168.1.102:8020")
				.config("spark.hadoop.yarn.resourcemanager.address","192.168.1.102:8032").getOrCreate();
	}

}
