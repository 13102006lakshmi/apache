```java
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkWordCount {
    public static void main(String[] args) {

        SparkConf conf = new SparkConf()
                .setAppName("Word Count")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> data = sc.textFile("input.txt");

        JavaRDD<String> words = data.flatMap(
                line -> java.util.Arrays.asList(line.split(" ")).iterator()
        );

        long count = words.count();

        System.out.println("Total number of words: " + count);

        sc.close();
    }
}
```
