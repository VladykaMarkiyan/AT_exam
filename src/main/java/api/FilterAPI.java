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

    public FilterResponse createFilter(String sessionId, FilterRequest filter) {
        RequestSpecification req = RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .formParam("name", filter.getName())
                .formParam("query", filter.getQuery())
                .redirects().follow(false);

        Response response = req.post("/query_store_page.php");
        return new FilterResponse(response);
    }
}
