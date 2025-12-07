package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPI {

    private final String baseUrl;

    public LoginAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response login(String username, String password) {
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUrl)
                .formParam("username", username)
                .formParam("password", password)
                .redirects().follow(false);
        return request.post("/login.php");
    }

    public Response logout() {
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUrl)
                .redirects().follow(false);
        return request.get("/logout_page.php");
    }
}
