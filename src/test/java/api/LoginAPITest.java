package api;

import io.restassured.response.Response;
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
        Response invalidLogin = loginAPI.login("wrongUser", "wrongPass");
        Assert.assertEquals(invalidLogin.getStatusCode(), 302);

        Response validLogin = loginAPI.login("administrator", "root");
        Assert.assertEquals(validLogin.getStatusCode(), 302);

        Response logoutResponse = loginAPI.logout();
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }
}
