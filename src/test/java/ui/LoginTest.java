package ui;

import core.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.bo.LoginBO;

public class LoginTest {

    private WebDriver driver;
    private LoginBO loginBO;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost:8989/");
        loginBO = new LoginBO(driver);
    }

    @Test
    public void invalidThenValidLoginTest() throws InterruptedException {
        loginBO.login("wrongUser", "wrongPass");
        Assert.assertTrue(loginBO.isErrorDisplayed());

        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        loginBO.logout();
        System.out.println("Logout visible? " + loginBO.isLogoutButtonDisplayed());
        Assert.assertFalse(loginBO.isLogoutButtonDisplayed());
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000); // щоб побачити результат
        DriverPool.quitDriver(); // <-- ось це замість driver.quit()
    }


}
