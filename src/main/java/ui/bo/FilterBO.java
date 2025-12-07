package ui.bo;

import org.openqa.selenium.WebDriver;
import ui.pages.FilterPage;
import ui.pages.LoginPage;

public class FilterBO {

    private final FilterPage filterPage;
    private final LoginPage loginPage;

    public FilterBO(WebDriver driver) {
        this.filterPage = new FilterPage(driver);
        this.loginPage = new LoginPage(driver);
    }

    public void goToBugBrowserTab() {
        filterPage.openBugBrowserTab();
    }

    public void clickSaveButton() {
        filterPage.clickSaveButton();
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

    public void logout() {
        loginPage.openUserMenu();
        loginPage.clickLogout();
    }

    public boolean isBugBrowserPageOpened() {
        return filterPage.isBugBrowserPageOpened();
    }

    public boolean isFilterNameFieldVisible() {
        return filterPage.isFilterNameFieldVisible();
    }

    public boolean isFilterApplied() {
        return filterPage.isFilterApplied();
    }
}
