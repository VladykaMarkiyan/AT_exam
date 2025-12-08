package api;

import api.requests.LoginRequest;
import api.requests.TaskRequest;
import api.responses.LoginResponse;
import api.responses.TaskResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaskAPITest {

    private LoginAPI loginAPI;
    private TaskAPI taskAPI;
    private final String baseUrl = "http://localhost:8989";

    @BeforeClass
    public void setup() {
        loginAPI = new LoginAPI(baseUrl);
        taskAPI = new TaskAPI(baseUrl);
    }

    @Test
    public void createTaskTest() {

        LoginRequest loginRequest = new LoginRequest("administrator", "root");
        LoginResponse loginResponse = loginAPI.login(loginRequest);
        Assert.assertEquals(loginResponse.getStatusCode(), 302);

        String sessionId = loginResponse.getSessionId();
        Assert.assertNotNull(sessionId, "PHPSESSID має бути присутній після логіну");

        TaskRequest taskRequest = new TaskRequest("Test Task API", "Опис тестового завдання");
        TaskResponse taskResponse = taskAPI.createTask(sessionId, taskRequest);
        Assert.assertEquals(taskResponse.getStatusCode(), 302);
        Assert.assertNotNull(taskResponse.getTaskId());

        LoginResponse logoutResponse = loginAPI.logout(sessionId);
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }
}
