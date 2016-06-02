package chainOfResponsibility;

// adjusted from:
// https://github.com/java8/Java8InAction/blob/master/src/main/java/lambdasinaction/chap8/ChainOfResponsibilityMain.java
public class ChainOfResponsibilityOld {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result1 = p1.handle("Aren't labdas really cool?!!");
        System.out.println(result1);
        
        // Task: Reduce code using lambdas (there will be no need for the inner classes below any more).
  
        // Hint 1: Replace the processing classes by a lambda using java.util.function.UnaryOperator<String>.
        // Hint 2: The base interface Function of UnaryOperator has a method called andThen(java.util.Function) 
        // which can be used for building a chain of processing lambdas.
         

    }

    static private abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }

        abstract protected T handleWork(T input);
    }

    static private class HeaderTextProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }
    }

    static private class SpellCheckerProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
