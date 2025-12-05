package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/view_all_bug_page.php']")
    private WebElement bugBrowserTab;

    @FindBy(xpath = "//a[@href='query_store_page.php']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@name='query_name']")
    private WebElement filterNameInput;

    @FindBy(xpath = "//input[@value='Зберегти поточний фільтр']")
    private WebElement saveCurrentFilterButton;

    @FindBy(xpath = "//input[@class='btn btn-primary btn-sm btn-white btn-round no-float']")
    private WebElement applyFilterButton;

    public void clickBugBrowserTab() {
        wait.until(ExpectedConditions.elementToBeClickable(bugBrowserTab)).click();
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void enterFilterName(String name) {
        wait.until(ExpectedConditions.visibilityOf(filterNameInput)).sendKeys(name);
    }

    public void clickSaveCurrentFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveCurrentFilterButton)).click();
    }

    public void clickApplyFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(applyFilterButton)).click();
    }

    public boolean isFilterNameInputVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(filterNameInput)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBugBrowserPageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(bugBrowserTab)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isApplyFilterButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(applyFilterButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
