package api;

import api.requests.FilterRequest;
import api.responses.FilterResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class FilterAPI {
    private final String baseUrl;

    public FilterAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response getAllBugs(String sessionId) {
        return RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .get("/view_all_bug_page.php");
    }

    public Response createFilter(String sessionId, String filterName) {
        return RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .formParam("filter_name", filterName)
                .redirects().follow(false)
                .post("/filter_create.php");
    }

}
