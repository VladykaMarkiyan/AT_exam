package api;

import io.restassured.response.Response;
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

        Response loginResponse = loginAPI.login("administrator", "root");
        Assert.assertEquals(loginResponse.getStatusCode(), 302);
        String token = loginResponse.getCookie("PHPSESSID");

        Response createTaskResponse = taskAPI.createTask(token, "Test Task", "Task description");
        Assert.assertEquals(createTaskResponse.getStatusCode(), 302);
    }
}
