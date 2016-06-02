package executeAround;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;

// adjusted from
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap3/ExecuteAround.java
public class ExecuteAroundNew {

    private static final String MY_FILE = "src/main/resources/words.txt";

    public static void main(String... args) throws IOException {

        // reading one line
        System.out.println("--------------------\n" + processFile(br -> br.readLine()));

        // reading two lines
        System.out.println("--------------------\n" + processFile(br -> br.readLine() + "\n" + br.readLine()));

        // read first 50 lines
        System.out.println("--------------------\n"
                + processFile(br -> br.lines().parallel().limit(50).collect(Collectors.joining("\n"))));

        // read first 50 lines
        System.out.println("--------------------\n" + processFile(
                br -> br.lines().parallel().limit(50).map(l -> l.toUpperCase()).collect(Collectors.joining("\n"))));

        System.out.println("--------------------\n"
                + processFile(br -> br.lines().parallel().map(l -> l.length()).reduce(Integer::max).toString()));

        System.out.println(
                "--------------------\n" + processFile(br -> br.lines().parallel().filter(l -> l.startsWith("A"))
                        .limit(1000).collect(Collectors.joining("\n"))));

    }

    public class StringWithCounter {
        int count;
        String s;
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(MY_FILE))) {
            return processor.process(br);
        }
    }

    private interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

}
