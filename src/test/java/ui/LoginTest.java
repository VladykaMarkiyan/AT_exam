package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.bo.LoginBO;
import data.LoginDataProvider;

public class LoginTest extends BaseUiTest {

    private LoginBO loginBO;

    @BeforeMethod
    public void init() {
        driver.get("http://localhost:8989/");
        loginBO = new LoginBO(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username, String password, boolean isSuccess) {
        loginBO.login(username, password);

        Assert.assertTrue(false, "Force fail to test screenshot attachment");

        if (isSuccess) {
            Assert.assertTrue(loginBO.isLogoutButtonDisplayed());
            loginBO.logout();
        } else {
            Assert.assertTrue(loginBO.isErrorDisplayed());
        }
    }
}
