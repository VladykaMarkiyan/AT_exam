package ui.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import core.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final ElementActions actions;

    public LoginPage(WebDriver driver) {
        this.actions = new ElementActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']")
    private WebElement nextButton;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='user-info']")
    private WebElement userMenuButton;

    @FindBy(xpath = "//a[@href='/logout_page.php']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement errorMessage;

    public void enterUsername(String username) {
        actions.clearAndType(usernameInput, username);
    }

    public void clickNext() {
        actions.click(nextButton);
    }

    public void enterPassword(String password) {
        actions.clearAndType(passwordInput, password);
    }

    public void clickLogin() {
        actions.click(loginButton);
    }

    public void openUserMenu() {
        actions.click(userMenuButton);
    }


    public boolean isLogoutButtonDisplayed() {
        try {
            actions.click(userMenuButton);
            return actions.isVisible(logoutButton);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        actions.click(logoutButton);
    }


    public boolean isErrorDisplayed() {
        return actions.isVisible(errorMessage);
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
