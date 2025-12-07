package ui.pages;

import core.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPage {

    private final ElementActions actions;

    public FilterPage(WebDriver driver) {
        this.actions = new ElementActions(driver);
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

    public void openBugBrowserTab() {
        actions.click(bugBrowserTab);
    }

    public void clickSaveButton() {
        actions.click(saveButton);
    }

    public void enterFilterName(String name) {
        actions.clearAndType(filterNameInput, name);
    }

    public void saveCurrentFilter() {
        actions.click(saveCurrentFilterButton);
    }

    public void applyFilter() {
        actions.click(applyFilterButton);
    }

    public boolean isFilterNameFieldVisible() {
        return actions.isVisible(filterNameInput);
    }

    public boolean isBugBrowserPageOpened() {
        return actions.isVisible(bugBrowserTab);
    }

    public boolean isFilterApplied() {
        return actions.isVisible(applyFilterButton);
    }
}
