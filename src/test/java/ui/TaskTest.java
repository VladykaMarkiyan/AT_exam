package ui;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.bo.LoginBO;
import ui.bo.TaskBO;

public class TaskTest extends BaseUiTest {

    private LoginBO loginBO;
    private TaskBO taskBO;

    @DataProvider(name = "projects")
    public Object[][] projects() {
        return new Object[][] {
                {"ProjectA", "Test description A"}
        };
    }

    @Test(dataProvider = "projects")
    public void createProjectTest(String name, String description) {
        loginBO = new LoginBO(driver);
        taskBO = new TaskBO(driver);

        driver.get("http://localhost:8989/");

        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        taskBO.openManageTab();
        taskBO.openProjectsTab();
        taskBO.createProject(name, description);
    }
}
