package ui.bo;

import org.openqa.selenium.WebDriver;
import ui.pages.FilterPage;

public class FilterBO {

    private final FilterPage filterPage;

    public FilterBO(WebDriver driver) {
        this.filterPage = new FilterPage(driver);
    }

    public void goToBugBrowserTab() {
        filterPage.openBugBrowserTab();
    }

    public boolean isBugBrowserPageOpened() {
        return filterPage.isBugBrowserPageOpened();
    }

    public void clickSaveButton() {
        filterPage.clickSaveButton();
    }

    public boolean isFilterNameFieldVisible() {
        return filterPage.isFilterNameFieldVisible();
    }

    public void enterFilterName(String name) {
        filterPage.enterFilterName(name);
    }

    public void saveCurrentFilter() {
        filterPage.saveCurrentFilter();
    }

    public void applyFilter() {
        filterPage.applyFilter();
    }

    public boolean isFilterApplied() {
        return filterPage.isFilterApplied();
    }

    public void logout() {
        filterPage.clickLogout();
    }

    public boolean isLogoutButtonDisplayed() {
        return filterPage.isLogoutButtonDisplayed();
    }
}
