package templateMethod;

import static common.Utils.printHeader;

public class TemplateMethodPatternLambda1 {
    
    public static void main(String[] args) {

        printHeader("default workflow");
        new Workflow().run();

        printHeader("running with customized task 2 and 3");
        new Workflow(//
                () -> System.out.println("Doing Task2.1..."), //
                () -> System.out.println("Doing Task3.1...")) //
                        .run();

        // looks better to me, but what if we have a lot of customizable tasks?
        // we do not want to pass them via constructor...

        // Task: allow initialization of workflow in a fluent way.

        // Hints:
        // - Use a Map to store the lambdas.
        // - Initialize the Map with default processing.
        // - Allow setting customized code using fluent style setter (a setter returning the instance of the class).

        // Solution: see TemplateMethodPatternLambda2
    }

    // workflow is not meant to be subclassed -> final
    private static final class Workflow {

        private final Runnable task2;
        private final Runnable task3;

        public Workflow() {
            this.task2 = () -> System.out.println("Doing Task2...");
            this.task3 = () -> System.out.println("Doing Task3...");
        }

        public Workflow(Runnable task2, Runnable task3) {
            this.task2 = task2;
            this.task3 = task3;
        }

        public final void doTask1() {
            System.out.println("Doing Task1...");
        }

        public final void doTask2() {
            task2.run();
        }

        public final void doTask3() {
            task3.run();
        }

        public final void doTask4() {
            System.out.println("Doing Task4...");
        }

        public final void run() {
            System.out.println("Starting the workflow ...");
            doTask1();
            doTask2();
            doTask3();
            doTask4();
        }
    }
}
