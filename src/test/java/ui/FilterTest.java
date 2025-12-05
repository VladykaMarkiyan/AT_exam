package ui;

import core.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.bo.LoginBO;
import ui.bo.FilterBO;

public class FilterTest {

    private WebDriver driver;
    private LoginBO loginBO;
    private FilterBO filterBO;

    private final String filterName = "TestFilter";

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost:8989/");
        loginBO = new LoginBO(driver);
        filterBO = new FilterBO(driver);
    }

    @Test
    public void createAndApplyFilterTest() {

        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        filterBO.goToBugBrowserTab();
        Assert.assertTrue(filterBO.isBugBrowserPageOpened());

        filterBO.clickSaveButton();
        Assert.assertTrue(filterBO.isFilterNameFieldVisible());

        filterBO.enterFilterName(filterName);

        filterBO.saveCurrentFilter();
        Assert.assertTrue(filterBO.isBackOnBugBrowserPage());

        filterBO.applyFilter();
        Assert.assertTrue(filterBO.isFilterApplied());

        filterBO.logout();
        Assert.assertFalse(loginBO.isLogoutButtonDisplayed());
    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
