package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.ElementActions;

public class TaskPage {

    private WebDriver driver;
    private ElementActions actions;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
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

    // ---------- Actions ----------

    public void clickManageTab() {
        actions.click(manageTab);
    }

    public boolean isManageTabVisible() {
        try {
            return manageTab.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProjectsTab() {
        actions.click(projectsTab);
    }

    public boolean isProjectsTabVisible() {
        try {
            return projectsTab.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCreateProjectButton() {
        actions.click(createProjectButton);
    }

    public void enterProjectName(String name) {
        actions.clearAndType(projectNameInput, name);
    }

    public void enterProjectDescription(String description) {
        actions.clearAndType(projectDescriptionInput, description);
    }

    public void clickAddProjectButton() {
        actions.click(addProjectButton);
    }

    public boolean isProjectVisible(String name) {
        try {
            WebElement projectLink = driver.findElement(By.xpath("//a[text()='" + name + "']"));
            return projectLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCreateProjectFormVisible() {
        try {
            return projectNameInput.isDisplayed()
                    && projectDescriptionInput.isDisplayed()
                    && addProjectButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
