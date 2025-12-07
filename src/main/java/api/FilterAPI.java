package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FilterAPI {

    private final String baseUrl;

    public FilterAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response getAllBugs(String sessionId) {
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId);
        return request.get("/view_all_bug_page.php");
    }

    public Response createFilter(String sessionId, String filterName) {
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .formParam("query_name", filterName);
        return request.post("/query_store_page.php");
    }
}
