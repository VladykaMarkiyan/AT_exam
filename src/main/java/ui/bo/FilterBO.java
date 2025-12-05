package ui.bo;

import org.openqa.selenium.WebDriver;
import ui.pages.FilterPage;
import ui.pages.LoginPage;

public class FilterBO {

    private FilterPage filterPage;
    private LoginPage loginPage;

    public FilterBO(WebDriver driver) {
        this.filterPage = new FilterPage(driver);
        this.loginPage = new LoginPage(driver); // 🔥 ОБОВ'ЯЗКОВО
    }

    public void goToBugBrowserTab() {
        filterPage.clickBugBrowserTab();
    }

    public void clickSaveButton() {
        filterPage.clickSaveButton();
    }

    public void enterFilterName(String name) {
        filterPage.enterFilterName(name);
    }

    public void saveCurrentFilter() {
        filterPage.clickSaveCurrentFilterButton();
    }

    public void applyFilter() {
        filterPage.clickApplyFilterButton();
    }

    public void logout() {
        loginPage.openUserMenu();
        loginPage.clickLogout();
    }

    public boolean isBugBrowserPageOpened() {
        return filterPage.isBugBrowserPageVisible();
    }

    public boolean isFilterNameFieldVisible() {
        return filterPage.isFilterNameInputVisible();
    }

    public boolean isBackOnBugBrowserPage() {
        return filterPage.isBugBrowserPageVisible();
    }

    public boolean isFilterApplied() {
        return filterPage.isApplyFilterButtonVisible();
    }

}
