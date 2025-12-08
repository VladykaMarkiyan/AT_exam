package api;

import api.requests.LoginRequest;
import api.requests.FilterRequest;
import api.responses.LoginResponse;
import api.responses.FilterResponse;
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

    @Test
    public void createFilterTest() {

        LoginRequest loginRequest = new LoginRequest("administrator", "root");
        LoginResponse loginResponse = loginAPI.login(loginRequest);
        Assert.assertEquals(loginResponse.getStatusCode(), 302);

        String sessionId = loginResponse.getSessionId();
        Assert.assertNotNull(sessionId);

        Assert.assertEquals(filterAPI.getAllBugs(sessionId).getStatusCode(), 200);

        FilterRequest filterRequest = new FilterRequest("TestFilterAPI", "status:open");
        FilterResponse filterResponse = filterAPI.createFilter(sessionId, filterRequest);
        Assert.assertEquals(filterResponse.getStatusCode(), 302);
        Assert.assertNotNull(filterResponse.getFilterId());

        LoginResponse logoutResponse = loginAPI.logout(sessionId);
        Assert.assertEquals(logoutResponse.getStatusCode(), 302);
    }
}
