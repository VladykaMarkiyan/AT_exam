package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='width-40 pull-right btn btn-success btn-inverse bigger-110']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='user-info']") //
    private WebElement userMenuButton;

    @FindBy(xpath = "//a[@href='/logout_page.php']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement errorMessage;

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void openUserMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userMenuButton)).click();

    }

    public void clickLogout() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }


    public boolean isLogoutButtonDisplayed() {
        try {
            openUserMenu();
            wait.until(ExpectedConditions.visibilityOf(logoutButton));
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
