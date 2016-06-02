package chainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

// adjusted from:
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/ChainOfResponsibilityMain.java
public class ChainOfResponsibilityLamdaWithMoreComments {

    public static void main(String[] args) {

        UnaryOperator<String> headerProcessing = (String text) -> "From raul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        // the same without lambda but using the UnaryOperator interface provided by Java 8:
        UnaryOperator<String> spellCheckerProcessing2 = new UnaryOperator<String>() {
            @Override
            public String apply(String text) {
                text= text.replaceAll("raul", "Raoul");
                return text;
            }
        };

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing)
                .andThen(spellCheckerProcessing2)
                // if lambda gets too complex we can still use a class using the Unary Operator interface provided by Java 8
                .andThen(new MyMoreComplexSpellChecker());
        String result2 = pipeline.apply("Aren't labdas really cool?!!");
        System.out.println(result2);
    }

    private static class MyMoreComplexSpellChecker implements UnaryOperator<String> {

        @Override
        public String apply(String text) {
            text = text.replaceAll("raul", "Raoul");
            text = text.replaceAll("Mario", "Max");
            text = text.replaceAll("Aren't", "");
            text = text.replaceAll("really cool\\?!!", "are definitely cool!!!");
            text = text.replaceAll("lambdas", "Lambdas");
            return text;
        }

    }

}
