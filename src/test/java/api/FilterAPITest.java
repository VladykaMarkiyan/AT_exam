package api;

import api.requests.LoginRequest;
import api.responses.LoginResponse;
import api.comporators.LoginResponseComparator;
import io.qameta.allure.Attachment;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterAPITest {

    private LoginAPI loginAPI;
    private FilterAPI filterAPI;
    private final String baseUrl = "http://localhost:8989";

    @BeforeClass
    public void setup() {
        loginAPI = new LoginAPI(baseUrl);
        filterAPI = new FilterAPI(baseUrl);
    }

    @Test(groups = "api")
    public void createFilterTest() {

        LoginRequest loginRequest = new LoginRequest("administrator", "root");
        LoginResponse loginResponse = loginAPI.login(loginRequest);
        attachLoginResponse(loginResponse);
        Assert.assertEquals(loginResponse.getStatusCode(), 200);
        Assert.assertNotNull(loginResponse.getCookie("PHPSESSID"));

        String sessionId = loginResponse.getCookie("PHPSESSID");

        Response allBugsResponse = filterAPI.getAllBugs(sessionId);
        attachFilterResponse(allBugsResponse);
        Assert.assertEquals(allBugsResponse.getStatusCode(), 200);

        Response createFilterResponse = filterAPI.createFilter(sessionId, "API Filter Test");
        attachFilterResponse(createFilterResponse);
        Assert.assertEquals(createFilterResponse.getStatusCode(), 404);

        LoginResponse logoutResponse = loginAPI.logout();
        attachLoginResponse(logoutResponse);
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }

    @Attachment(value = "Login API Response", type = "application/json")
    public String attachLoginResponse(LoginResponse response) {
        return response.getRawResponse().asString();
    }

    @Attachment(value = "Filter API Response", type = "application/json")
    public String attachFilterResponse(Response response) {
        return response.asString();
    }
}
