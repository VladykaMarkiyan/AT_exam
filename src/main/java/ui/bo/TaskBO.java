package ui.bo;

import org.openqa.selenium.WebDriver;
import ui.pages.TaskPage;

public class TaskBO {

    private TaskPage taskPage;

    public TaskBO(WebDriver driver) {
        taskPage = new TaskPage(driver);
    }

    public void goToManageTab() {
        taskPage.clickManageTab();
    }

    public boolean isManageTabVisible() {
        return taskPage.isManageTabVisible();
    }

    public void goToManageProjects() {
        taskPage.clickProjectsTab();
    }

    public boolean isManageProjectsVisible() {
        return taskPage.isProjectsTabVisible();
    }

    public void clickCreateProject() {
        taskPage.clickCreateProjectButton();
    }

    public boolean isCreateProjectFormVisible() {
        return taskPage.isCreateProjectFormVisible();
    }

    public void enterProjectName(String name) {
        taskPage.enterProjectName(name);
    }

    public void enterProjectDescription(String description) {
        taskPage.enterProjectDescription(description);
    }

    public void clickAddProject() {
        taskPage.clickAddProjectButton();
    }

    public boolean isProjectVisible(String name) {
        return taskPage.isProjectVisible(name);
    }
}
