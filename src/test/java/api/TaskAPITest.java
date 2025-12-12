package api;

import api.requests.LoginRequest;
import api.responses.LoginResponse;
import api.comporators.LoginResponseComparator;
import io.qameta.allure.Attachment;
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

        LoginRequest loginRequest = new LoginRequest("administrator", "root");
        LoginResponse loginResponse = loginAPI.login(loginRequest);
        attachLoginResponse(loginResponse);
        Assert.assertEquals(loginResponse.getStatusCode(), 200);
        Assert.assertNotNull(loginResponse.getCookie("PHPSESSID"));

        String sessionId = loginResponse.getCookie("PHPSESSID");

        Response createTaskResponse = taskAPI.createTask(sessionId, "API Test Task", "Task created by API test");
        attachTaskResponse(createTaskResponse);
        Assert.assertEquals(createTaskResponse.getStatusCode(), 404);

        LoginResponse logoutResponse = loginAPI.logout();
        attachLoginResponse(logoutResponse);
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }

    @Attachment(value = "Login API Response", type = "application/json")
    public String attachLoginResponse(LoginResponse response) {
        return response.getRawResponse().asString();
    }

    @Attachment(value = "Task API Response", type = "application/json")
    public String attachTaskResponse(Response response) {
        return response.asString();
    }
}
