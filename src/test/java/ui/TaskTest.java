package ui;

import core.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.bo.LoginBO;
import ui.bo.TaskBO;

public class TaskTest {

    private WebDriver driver;
    private LoginBO loginBO;
    private TaskBO taskBO;

    private final String projectName = "MyTestProject";
    private final String projectDescription = "Description for MyTestProject";

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost:8989/");
        loginBO = new LoginBO(driver);
        taskBO = new TaskBO(driver);
    }

    @Test
    public void loginAndCreateProjectTest() throws InterruptedException {

        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        taskBO.goToManageTab();
        Assert.assertTrue(taskBO.isManageTabVisible());

        taskBO.goToManageProjects();
        Assert.assertTrue(taskBO.isManageProjectsVisible());

        taskBO.clickCreateProject();
        Assert.assertTrue(taskBO.isCreateProjectFormVisible());

        taskBO.enterProjectName(projectName);
        taskBO.enterProjectDescription(projectDescription);

        taskBO.clickAddProject();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        DriverPool.quitDriver();
    }
}
