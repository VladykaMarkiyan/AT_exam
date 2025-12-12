package ui;

import core.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.bo.LoginBO;
import data.LoginDataProvider;

public class LoginTest {

    private WebDriver driver;
    private LoginBO loginBO;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost:8989/");
        loginBO = new LoginBO(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username, String password, boolean isSuccess) {

        loginBO.login(username, password);

        if (isSuccess) {
            Assert.assertTrue(loginBO.isLogoutButtonDisplayed(), "Logout button expected!");
            loginBO.logout();
        } else {
            Assert.assertTrue(loginBO.isErrorDisplayed(), "Error expected!");
        }
    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
