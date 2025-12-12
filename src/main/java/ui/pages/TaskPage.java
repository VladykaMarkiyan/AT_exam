    package ui.pages;

    import core.ElementActions;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import ui.components.Button;
    import ui.components.TextField;

    public class TaskPage {

        private WebDriver driver;
        private ElementActions actions;

        public TaskPage(WebDriver driver) {
            this.driver = driver;
            this.actions = new ElementActions(driver);
            PageFactory.initElements(driver, this);
            initComponents();
        }

        @FindBy(xpath = "//a[@href='/manage_overview_page.php']")
        private WebElement manageTabElement;
        private Button manageTab;

        @FindBy(xpath = "//a[@href='/manage_proj_page.php']")
        private WebElement projectsTabElement;
        private Button projectsTab;

        @FindBy(xpath = "//button[@class='btn btn-primary btn-white btn-round']")
        private WebElement createProjectButtonElement;
        private Button createProjectButton;

        @FindBy(xpath = "//input[@id='project-name']")
        private WebElement projectNameInputElement;
        private TextField projectNameInput;

        @FindBy(xpath = "//textarea[@id='project-description']")
        private WebElement projectDescriptionInputElement;
        private TextField projectDescriptionInput;

        @FindBy(xpath = "//input[@value='Додати проект']")
        private WebElement addProjectButtonElement;
        private Button addProjectButton;

        private void initComponents() {
            manageTab = new Button(manageTabElement);
            projectsTab = new Button(projectsTabElement);
            createProjectButton = new Button(createProjectButtonElement);
            projectNameInput = new TextField(projectNameInputElement);
            projectDescriptionInput = new TextField(projectDescriptionInputElement);
            addProjectButton = new Button(addProjectButtonElement);
        }

        public void clickManageTab() { manageTab.click(); }
        public boolean isManageTabVisible() { return manageTabElement.isDisplayed(); }

        public void clickProjectsTab() { projectsTab.click(); }
        public boolean isProjectsTabVisible() { return projectsTabElement.isDisplayed(); }

        public void clickCreateProjectButton() { createProjectButton.click(); }

        public void enterProjectName(String name) { projectNameInput.setText(name); }
        public void enterProjectDescription(String description) { projectDescriptionInput.setText(description); }
        public void clickAddProjectButton() { addProjectButton.click(); }

        public boolean isProjectVisible(String name) {
            try {
                WebElement projectLink = driver.findElement(
                        By.xpath("//div[contains(@class,'widget-box widget-color-blue2')]//a[contains(.,'" + name + "')]")
                );
                return projectLink.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }


        public boolean isCreateProjectFormVisible() {
            try {
                return projectNameInputElement.isDisplayed() &&
                        projectDescriptionInputElement.isDisplayed() &&
                        addProjectButtonElement.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }
