package templateMethod;

// from: https://dzone.com/articles/template-method-pattern-using
public class TemplateMethodPatternWithInterfaceDefaultMethod {
    public static void main(String[] args) {
        /**
         * Using lambda expression to create different implementation of the abstract workflow
         */
        initiateWorkFlow(() -> System.out.println("Doing Task2.1..."));
        initiateWorkFlow(() -> System.out.println("Doing Task2.2..."));
        initiateWorkFlow(() -> System.out.println("Doing Task2.3..."));
        
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // BUT: allows customization of only 1 method! 
        // Seems like a misuse of default methods to me...
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
    }

    static void initiateWorkFlow(WorkflowManager workflowMgr) {
        System.out.println("Starting the workflow ...");
        workflowMgr.doTask1();
        workflowMgr.doTask2();
        workflowMgr.doTask3();
        workflowMgr.doTask4();
    }
}

interface WorkflowManager {
    public default void doTask1() {
        System.out.println("Doing Task1...");
    }

    public void doTask2();
    
    public default void doTask3() {
        System.out.println("Doing Task3...");
    }

    public default void doTask4() {
        System.out.println("Doing Task4...");
    }
}
