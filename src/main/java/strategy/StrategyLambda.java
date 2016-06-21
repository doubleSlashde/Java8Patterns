package strategy;

import strategy.common.Validator;

// adjusted from: 
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/StrategyMain.java
public class StrategyLambda {

    public static void main(String[] args) {

        Validator v3 = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(v3.validate("aaaa"));
        
        Validator v4 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(v4.validate("bbbb"));
        
        // Hint: You can even get rid of the ValidationStrategy interface by replacing it in the Validator class using Function<String, Boolean> instead 
        
    }

}
