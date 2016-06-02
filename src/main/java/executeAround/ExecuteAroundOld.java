package executeAround;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// adjusted from
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap3/ExecuteAround.java
public class ExecuteAroundOld {

    private static final String MY_FILE = "src/main/resources/words.txt";

    public static void main(String... args) throws IOException {

        // This is the method we want to refactor to make it more flexible.
        String result = processFile();
        System.out.println(result);

        // Task: Make the reading process more flexible so it can execute any kind of processing on the buffered reader.
        // 1) read two lines into a String
        // 2) read the first 50 lines and uppercase them
        // 3) find out which line is the longest
        // 4) find the first 1000 lines that start with A
        // 5) think of something yourself ;-)
        
        // Hint: Define a functional interface named BufferedReaderProcessor, which has one method:
        // String process(BufferedReader br) throws IOException;
        // This will enable you to refactor the method in such a way that you can pass in the reading behavior.
        // For reading and filtering all lines you can make use of the new stream method lines() in BufferedReader.

    }

    public static String processFile() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(MY_FILE))) {
            return br.readLine();
        }
    }
}
