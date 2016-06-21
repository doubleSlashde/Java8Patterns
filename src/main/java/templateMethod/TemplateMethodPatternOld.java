package templateMethod;

public class TemplateMethodPatternOld {

    public static void main(String[] args) {
        
        initiateWorkFlow(new WorkflowImpl1());
        initiateWorkFlow(new WorkflowImpl2());
        
        // Task: Refactor this by using Lambdas. 
        
        // Hint: Pass the customizable behavior as lambdas via constructor.
        
        // Solution: see TemplateMethodPatternLambda1
        
    }

    static void initiateWorkFlow(Workflow workflowMgr) {
        System.out.println("Starting the workflow ... the old way");
        workflowMgr.doTask1();
        workflowMgr.doTask2();
        workflowMgr.doTask3();
        workflowMgr.doTask4();
    }

    /**
     * Abstract Workflow system
     */
    private static abstract class Workflow {

        public void doTask1() {
            System.out.println("Doing Task1...");
        }

        public abstract void doTask2();

        public abstract void doTask3();

        public void doTask4() {
            System.out.println("Doing Task4...");
        }

    }

    /**
     * One of the extensions of the abstract workflow system
     */
    private static class WorkflowImpl1 extends Workflow {
        @Override
        public void doTask2() {
            System.out.println("Doing Task2.1...");
        }

        @Override
        public void doTask3() {
            System.out.println("Doing Task3.1...");
        }
    }

    /**
     * Other extension of the abstract workflow system
     */
    private static class WorkflowImpl2 extends Workflow {
        @Override
        public void doTask2() {
            System.out.println("Doing Task2.2...");
        }

        @Override
        public void doTask3() {
            System.out.println("Doing Task3.2...");
        }
    }
}
