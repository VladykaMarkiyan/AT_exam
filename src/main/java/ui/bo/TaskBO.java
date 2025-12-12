package ui.bo;

import org.openqa.selenium.WebDriver;
import ui.pages.TaskPage;

public class TaskBO {

    private TaskPage taskPage;

    public TaskBO(WebDriver driver) {
        taskPage = new TaskPage(driver);
    }

    public void openManageTab() {
        taskPage.clickManageTab();
    }

    public void openProjectsTab() {
        taskPage.clickProjectsTab();
    }

    public void createProject(String name, String description) {
        taskPage.clickCreateProjectButton();
        taskPage.enterProjectName(name);
        taskPage.enterProjectDescription(description);
        taskPage.clickAddProjectButton();
    }

    public boolean isProjectVisible(String name) {
        return taskPage.isProjectVisible(name);
    }

    public boolean isCreateProjectFormVisible() {
        return taskPage.isCreateProjectFormVisible();
    }
}
