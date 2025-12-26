package api;

import api.requests.LoginRequest;
import api.responses.LoginResponse;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAPITest {

    private LoginAPI loginAPI;
    private final String baseUrl = "http://localhost:8989";

    @BeforeClass
    public void setup() {
        loginAPI = new LoginAPI(baseUrl);
    }

    @Test(groups = "api")
    public void invalidThenValidLoginTest() {

        LoginRequest invalidRequest = new LoginRequest("wrongUser", "wrongPass");
        LoginResponse invalidResponse = loginAPI.login(invalidRequest);
        logResponse("Invalid login", invalidResponse);
        Assert.assertEquals(invalidResponse.getStatusCode(), 200);

        LoginRequest validRequest = new LoginRequest("administrator", "root");
        LoginResponse validResponse = loginAPI.login(validRequest);
        logResponse("Valid login", validResponse);
        Assert.assertEquals(validResponse.getStatusCode(), 200);
        Assert.assertNotNull(validResponse.getCookie("PHPSESSID"));

        LoginResponse logoutResponse = loginAPI.logout();
        logResponse("Logout", logoutResponse);
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }

    public void logResponse(String step, LoginResponse response) {
        System.out.println("=== " + step + " ===");
        System.out.println("Status code: " + response.getStatusCode());
        if(response.getCookie("PHPSESSID") != null) {
            System.out.println("Session cookie: " + response.getCookie("PHPSESSID"));
        }
        System.out.println("Short body: " + getShortBody(response.getRawResponse().asString()));
        System.out.println("==================");
    }

    public String getShortBody(String body) {
        return body.length() > 200 ? body.substring(0, 200) + "..." : body;
    }
}
