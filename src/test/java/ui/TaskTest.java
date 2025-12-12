package ui;

import core.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.bo.LoginBO;
import ui.bo.TaskBO;

public class TaskTest {

    private WebDriver driver;
    private LoginBO loginBO;
    private TaskBO taskBO;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost:8989/");
        loginBO = new LoginBO(driver);
        taskBO = new TaskBO(driver);
    }

    @DataProvider(name = "projects")
    public Object[][] projects() {
        return new Object[][] {
                {"ProjectA", "Test description A"}
        };
    }

    @Test(dataProvider = "projects")
    public void createProjectTest(String name, String description) {

        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        taskBO.openManageTab();
        taskBO.openProjectsTab();

        taskBO.createProject(name, description);

    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
