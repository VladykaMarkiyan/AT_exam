package data;

import org.testng.annotations.DataProvider;

public class TaskDataProvider {

    @DataProvider(name = "taskData")
    public static Object[][] taskData() {
        return new Object[][] {
                {"Fix login bug", "High"},
                {"Refactor user service", "Medium"},
                {"Write unit tests", "Low"}
        };
    }
}
