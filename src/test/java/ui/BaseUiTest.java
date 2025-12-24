package ui;

import core.DriverPool;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseUiTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverPool.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {

            byte[] screenshotBytes = takeScreenshot(driver);

            saveScreenshotToFile(screenshotBytes, result.getName());
        }

        DriverPool.quitDriver();
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void saveScreenshotToFile(byte[] bytes, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        File screenshotFile = new File(screenshotDir, testName + "_" + timestamp + ".png");
        try {
            FileUtils.writeByteArrayToFile(screenshotFile, bytes);
            System.out.println("Saved screenshot: " + screenshotFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
