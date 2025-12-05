package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/manage_overview_page.php']")
    private WebElement manageTab;

    @FindBy(xpath = "//a[@href='/manage_proj_page.php']")
    private WebElement projectsTab;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-white btn-round']")
    private WebElement createProjectButton;

    @FindBy(xpath = "//input[@id='project-name']")
    private WebElement projectNameInput;

    @FindBy(xpath = "//textarea[@id='project-description']")
    private WebElement projectDescriptionInput;

    @FindBy(xpath = "//input[@value='Додати проект']")
    private WebElement addProjectButton;

    public void clickManageTab() {
        wait.until(ExpectedConditions.elementToBeClickable(manageTab)).click();
    }

    public boolean isManageTabVisible() {
        try {
            return manageTab.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProjectsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(projectsTab)).click();
    }

    public boolean isProjectsTabVisible() {
        try {
            return projectsTab.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCreateProjectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createProjectButton)).click();

        wait.until(ExpectedConditions.visibilityOf(projectNameInput));
        wait.until(ExpectedConditions.visibilityOf(projectDescriptionInput));
        wait.until(ExpectedConditions.visibilityOf(addProjectButton));
    }

    public void enterProjectName(String name) {
        wait.until(ExpectedConditions.visibilityOf(projectNameInput)).clear();
        projectNameInput.sendKeys(name);
    }

    public void enterProjectDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(projectDescriptionInput)).clear();
        projectDescriptionInput.sendKeys(description);
    }

    public void clickAddProjectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addProjectButton)).click();
    }

    public boolean isProjectVisible(String name) {
        try {
            WebElement projectLink = driver.findElement(By.xpath("//a[text()='" + name + "']"));
            wait.until(ExpectedConditions.visibilityOf(projectLink));
            return projectLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCreateProjectFormVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(projectNameInput));
            wait.until(ExpectedConditions.visibilityOf(projectDescriptionInput));
            wait.until(ExpectedConditions.visibilityOf(addProjectButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
