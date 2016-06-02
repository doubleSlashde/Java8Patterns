package strategy;

import strategy.common.ValidationStrategy;
import strategy.common.Validator;

// adjusted from: 
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/StrategyMain.java
public class StrategyOld {

    public static void main(String[] args) {

        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaaa"));

        Validator v2 = new Validator(new IsAllLowerCase());
        System.out.println(v2.validate("bbbb"));
        
        // Task: replace validation strategies using lambda expressions
    }

    private static class IsAllLowerCase implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    private static class IsNumeric implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

}
