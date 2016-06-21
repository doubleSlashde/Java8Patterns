package executeAround;

import static common.Utils.printHeader;

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

        printHeader("read one line");
        System.out.println(processFile(br -> br.readLine()));

        printHeader("read two lines");
        System.out.println(processFile(br -> br.readLine() + "\n" + br.readLine()));

        printHeader("read first 50 lines (parallel)");
        System.out.println(processFile(br -> br.lines().parallel().limit(50).collect(Collectors.joining("\n"))));

        printHeader("read first 50 lines (parallel)");
        System.out.println(processFile(
                br -> br.lines().parallel().limit(50).map(l -> l.toUpperCase()).collect(Collectors.joining("\n"))));

        printHeader("find length of longest line (parallel) - version 1");
        System.out
                .println(processFile(br -> br.lines().parallel().map(l -> l.length()).reduce(Integer::max).toString()));

        printHeader("find longest line (parallel) - version 1");
        System.out.println(
                processFile(br -> br.lines().parallel().max(Comparator.comparingInt(String::length)).toString()));

        printHeader("find longest line (parallel) - version 2");
        System.out.println(processFile(br -> br.lines().parallel().reduce((x, y) -> {
            return x.length() > y.length() ? x : y;
        }).toString()));

        printHeader("find first 1000 lines starting with A (parallel)");
        System.out.println(processFile(br -> br.lines().parallel().filter(l -> l.startsWith("A")).limit(1000)
                .collect(Collectors.joining("\n"))));

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
