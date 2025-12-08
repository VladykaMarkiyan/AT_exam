package api;

import api.requests.LoginRequest;
import api.responses.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class LoginAPI {
    private final String baseUrl;

    public LoginAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public LoginResponse login(LoginRequest request) {
        RequestSpecification req = RestAssured.given()
                .baseUri(baseUrl)
                .formParam("username", request.getUsername())
                .formParam("password", request.getPassword())
                .redirects().follow(false);

        Response response = req.post("/login_page.php");
        return new LoginResponse(response);
    }

    public LoginResponse logout(String sessionId) {
        RequestSpecification req = RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .redirects().follow(false);

        Response response = req.get("/account_page.php");
        return new LoginResponse(response);
    }
}
