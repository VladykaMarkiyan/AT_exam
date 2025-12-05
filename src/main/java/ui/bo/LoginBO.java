package ui.bo;

import ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBO {

    private LoginPage loginPage;

    public LoginBO(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.clickNext();
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public boolean isErrorDisplayed() {
        return loginPage.isErrorDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {
        return loginPage.isLogoutButtonDisplayed();
    }

    public void logout() {
        loginPage.clickLogout();
    }

}
