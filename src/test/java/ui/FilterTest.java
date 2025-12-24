package ui;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.bo.FilterBO;
import ui.bo.LoginBO;

public class FilterTest extends BaseUiTest {

    private LoginBO loginBO;
    private FilterBO filterBO;

    @DataProvider(name = "filters")
    public Object[][] filters() {
        return new Object[][] {
                {"TestFilter"}
        };
    }

    @Test(dataProvider = "filters")
    public void createAndApplyFilterTest(String filterName) {
        loginBO = new LoginBO(driver);
        filterBO = new FilterBO(driver);

        driver.get("http://localhost:8989/");

        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        filterBO.goToBugBrowserTab();
        Assert.assertTrue(filterBO.isBugBrowserPageOpened());

        filterBO.clickSaveButton();
        Assert.assertTrue(filterBO.isFilterNameFieldVisible());

        filterBO.enterFilterName(filterName);
        filterBO.saveCurrentFilter();

        Assert.assertTrue(filterBO.isBugBrowserPageOpened());

        filterBO.applyFilter();
        Assert.assertTrue(filterBO.isFilterApplied());

        filterBO.logout();
        Assert.assertFalse(loginBO.isLogoutButtonDisplayed());
    }
}
