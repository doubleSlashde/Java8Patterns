package templateMethod;

import static common.Utils.printHeader;

import java.util.HashMap;
import java.util.Map;

import templateMethod.TemplateMethodPatternOld.WorkflowManager2;

public class TemplateMethodPatternLambda2 {
    public static void main(String[] args) {

        printHeader("default workflow");
        new Workflow().run();

        printHeader("running with three differently customized task 2");
        {
            Workflow workflow = new Workflow();
            workflow.setTask("task2", () -> System.out.println("Doing Task2.1...")).run();
            workflow.setTask("task2", () -> System.out.println("Doing Task2.2...")).run();
            workflow.setTask("task2", () -> System.out.println("Doing Task2.3...")).run();
        }

        printHeader("now you can change multiple tasks in the workflow, not only one");
        new Workflow() //
                .setTask("task2", () -> System.out.println("Doing Task2.1...")) //
                .setTask("task3", () -> System.out.println("Doing Task3.1...")) //
                .run();

        printHeader("trying to set a task that does not exist in the workflow");
        try {
            new Workflow().setTask("task6", () -> System.out.println("Doing Task6...")).run();
        } catch (IllegalArgumentException iae) {
            System.out.println("expected exception: " + iae.getMessage());
        }

    }
    

    // workflow is not meant to be subclassed -> final
    static final class Workflow {

        private Map<String, Runnable> tasks = new HashMap<>();

        {
            tasks.put("task1", () -> System.out.println("Doing Task1..."));
            tasks.put("task2", () -> System.out.println("Doing Task2..."));
            tasks.put("task3", () -> System.out.println("Doing Task3..."));
            tasks.put("task4", () -> System.out.println("Doing Task4..."));
            // if there is no default behavior you can use an empty lambda: () -> {}
        }

        public final void doTask(String taskKey) {
            tasks.get(taskKey).run();
        }

        public final Runnable getTask(String taskKey) {
            return tasks.get(taskKey);
        }

        public final Workflow setTask(String taskKey, Runnable runnable) {
            if (!tasks.containsKey(taskKey)) {
                throw new IllegalArgumentException(String.format("illegal task key %s", taskKey));
            }
            tasks.put(taskKey, runnable);
            return this;
        }

        public final void run() {
            System.out.println("Starting the workflow ...");
            this.doTask("task1");
            this.doTask("task2");
            this.doTask("task3");
            this.doTask("task4");
        }
    }
}
