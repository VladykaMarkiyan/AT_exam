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
import java.util.NoSuchElementException;

public class FilterPage {

    private final WebDriver driver;
    private final ElementActions actions;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
        PageFactory.initElements(driver, this);
        initComponents();
    }

    @FindBy(xpath = "//a[@href='/view_all_bug_page.php']")
    private WebElement bugBrowserTabElement;
    private Button bugBrowserTab;

    @FindBy(xpath = "//a[@href='query_store_page.php']")
    private WebElement saveButtonElement;
    private Button saveButton;

    @FindBy(xpath = "//input[@name='query_name']")
    private WebElement filterNameInputElement;
    private TextField filterNameInput;

    @FindBy(xpath = "//input[@value='Зберегти поточний фільтр']")
    private WebElement saveCurrentFilterButtonElement;
    private Button saveCurrentFilterButton;

    @FindBy(xpath = "//input[contains(@class,'btn-primary') and contains(@class,'btn-round')]")
    private WebElement applyFilterButtonElement;
    private Button applyFilterButton;

    @FindBy(xpath = "//span[@class='user-info']")
    private WebElement userMenuButton;

    @FindBy(xpath = "//a[@href='/logout_page.php']")
    private WebElement logoutButton;

    private void initComponents() {
        bugBrowserTab = new Button(bugBrowserTabElement);
        saveButton = new Button(saveButtonElement);
        filterNameInput = new TextField(filterNameInputElement);
        saveCurrentFilterButton = new Button(saveCurrentFilterButtonElement);
        applyFilterButton = new Button(applyFilterButtonElement);
    }

    public void openBugBrowserTab() { bugBrowserTab.click(); }
    public void clickSaveButton() { saveButton.click(); }
    public void enterFilterName(String name) { filterNameInput.setText(name); }
    public void saveCurrentFilter() { saveCurrentFilterButton.click(); }
    public void applyFilter() { applyFilterButton.click(); }

    public boolean isFilterNameFieldVisible() { return filterNameInputElement.isDisplayed(); }
    public boolean isBugBrowserPageOpened() { return bugBrowserTabElement.isDisplayed(); }
    public boolean isFilterApplied() { return applyFilterButtonElement.isDisplayed(); }

    public void openUserMenu() {
        userMenuButton.click();
    }

    public void clickLogout() {
        openUserMenu();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public boolean isLogoutButtonDisplayed() {
        try {
            return logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
