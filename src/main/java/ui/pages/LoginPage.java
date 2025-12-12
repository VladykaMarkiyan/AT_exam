package ui.pages;

import core.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.components.Button;
import ui.components.TextField;

import java.time.Duration;

public class LoginPage {

    private final ElementActions actions;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.actions = new ElementActions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // таймаут 10 сек
        PageFactory.initElements(driver, this);
        initComponents();
    }

    private TextField usernameInputField;
    private TextField passwordInputField;
    private Button nextButtonComponent;
    private Button loginButtonComponent;
    private Button logoutButtonComponent;
    private WebElement errorMessage;

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
    private WebElement errorMessageElement;

    private void initComponents() {
        usernameInputField = new TextField(usernameInput);
        passwordInputField = new TextField(passwordInput);
        nextButtonComponent = new Button(nextButton);
        loginButtonComponent = new Button(loginButton);
        logoutButtonComponent = new Button(logoutButton);
        errorMessage = errorMessageElement;
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)); // чекаємо, поки поле буде видимим
        usernameInput.clear(); // очищаємо поле перед набором
        usernameInputField.setText(username);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButtonComponent.click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInputField.setText(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonComponent.click();
    }

    public boolean isLogoutButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userMenuButton));
            userMenuButton.click();
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonComponent.click();
    }

    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
    }
}
