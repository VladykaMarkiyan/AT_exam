package api;

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

    @Test
    public void createFilterTest() {
        Response loginResponse = loginAPI.login("administrator", "root");
        Assert.assertEquals(loginResponse.getStatusCode(), 302);

        String sessionId = loginResponse.getCookie("PHPSESSID");
        Assert.assertNotNull(sessionId, "PHPSESSID має бути присутній після логіну");

        Response allBugs = filterAPI.getAllBugs(sessionId);
        Assert.assertEquals(allBugs.getStatusCode(), 200);

        String filterName = "TestFilterAPI";
        Response createFilter = filterAPI.createFilter(sessionId, filterName);
        Assert.assertEquals(createFilter.getStatusCode(), 302);

        Response logout = loginAPI.logout();
        Assert.assertEquals(logout.getStatusCode(), 302);
    }
}
