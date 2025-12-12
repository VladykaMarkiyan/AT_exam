package ui;

import core.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.bo.FilterBO;
import ui.bo.LoginBO;

public class FilterTest {

    private WebDriver driver;
    private LoginBO loginBO;
    private FilterBO filterBO;

    @BeforeClass
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.get("http://localhost:8989/");  // сторінка логіну
        loginBO = new LoginBO(driver);
        filterBO = new FilterBO(driver);
    }

    @DataProvider(name = "filters")
    public Object[][] filters() {
        return new Object[][] {
                {"TestFilter"},
        };
    }

    @Test(dataProvider = "filters")
    public void createAndApplyFilterTest(String filterName) {

        // Логін
        driver.get("http://localhost:8989/");  // переконаємось, що на логіні
        loginBO.login("administrator", "root");
        Assert.assertTrue(loginBO.isLogoutButtonDisplayed());

        // Перехід до Bug Browser
        filterBO.goToBugBrowserTab();
        Assert.assertTrue(filterBO.isBugBrowserPageOpened());

        // Збереження нового фільтру
        filterBO.clickSaveButton();
        Assert.assertTrue(filterBO.isFilterNameFieldVisible());

        filterBO.enterFilterName(filterName);
        filterBO.saveCurrentFilter();

        Assert.assertTrue(filterBO.isBugBrowserPageOpened());

        // Застосування фільтру
        filterBO.applyFilter();
        Assert.assertTrue(filterBO.isFilterApplied());

        // Логаут
        filterBO.logout();
        Assert.assertFalse(loginBO.isLogoutButtonDisplayed());
    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
