package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverPool {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.get("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    driver.set(createChromeDriver());
                    break;
                case "firefox":
                    driver.set(createFirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            setupWindow(driver.get());
        }
        return driver.get();
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static void setupWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
