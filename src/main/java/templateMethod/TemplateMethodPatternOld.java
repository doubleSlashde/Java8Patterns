package templateMethod;

public class TemplateMethodPatternOld {

    public static void main(String[] args) {
        
        initiateWorkFlow(new WorkflowManager2Impl1());
        initiateWorkFlow(new WorkflowManager2Impl2());
        
        // Task: Refactor this by using Lambdas. 
        
        // Hint: Pass the customizable behavior as lambdas via constructor.
        
        // Solution: see TemplateMethodPatternLambda1
        
    }

    static void initiateWorkFlow(WorkflowManager2 workflowMgr) {
        System.out.println("Starting the workflow ... the old way");
        workflowMgr.doTask1();
        workflowMgr.doTask2();
        workflowMgr.doTask3();
        workflowMgr.doTask4();
    }

    /**
     * Abstract Workflow system
     */
    static abstract class WorkflowManager2 {

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
    static class WorkflowManager2Impl1 extends WorkflowManager2 {
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
    static class WorkflowManager2Impl2 extends WorkflowManager2 {
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
