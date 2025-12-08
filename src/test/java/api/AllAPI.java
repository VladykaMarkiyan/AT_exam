package api;

import org.testng.annotations.Test;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class AllAPI {

    @Test
    public void runAllAPITests() {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {
                LoginAPITest.class,
                TaskAPITest.class,
                FilterAPITest.class
        });
        testng.addListener(tla);
        testng.run();
    }
}
