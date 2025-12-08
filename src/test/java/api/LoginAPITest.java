package api;

import api.requests.LoginRequest;
import api.responses.LoginResponse;
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

    @Test
    public void invalidThenValidLoginTest() {

        LoginRequest invalidRequest = new LoginRequest("wrongUser", "wrongPass");
        LoginResponse invalidResponse = loginAPI.login(invalidRequest);

        LoginRequest validRequest = new LoginRequest("administrator", "root");
        LoginResponse validResponse = loginAPI.login(validRequest);

        Assert.assertEquals(validResponse.getStatusCode(), 302);
        Assert.assertNotNull(validResponse.getSessionId());

        LoginResponse logoutResponse = loginAPI.logout(validResponse.getSessionId());
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }



}
