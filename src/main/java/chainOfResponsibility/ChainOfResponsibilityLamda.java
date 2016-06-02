package chainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

// adjusted from:
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/ChainOfResponsibilityMain.java
public class ChainOfResponsibilityLamda {

    public static void main(String[] args) {

        UnaryOperator<String> headerProcessing = (String text) -> "From raul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        // Function#andThen -> Chain of Responsibility 
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really cool?!!");
        System.out.println(result2);
    }

 

}
