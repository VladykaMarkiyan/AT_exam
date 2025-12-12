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
        System.out.println("=== LOGIN REQUEST ===");
        System.out.println("URL: " + baseUrl + "/login_page.php");
        System.out.println("Username: " + request.getUsername());
        System.out.println("Password: " + request.getPassword());

        RequestSpecification spec = RestAssured.given()
                .baseUri(baseUrl)
                .formParam("username", request.getUsername())
                .formParam("password", request.getPassword())
                .redirects().follow(false);

        Response response = spec.post("/login_page.php");

        System.out.println("--- RESPONSE ---");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Body: " + response.asString());
        System.out.println("Cookies: " + response.getCookies());
        System.out.println("=================");

        return new LoginResponse(response);
    }

    public LoginResponse logout() {
        System.out.println("=== LOGOUT REQUEST ===");
        System.out.println("URL: " + baseUrl + "/logout_page.php");

        RequestSpecification spec = RestAssured.given()
                .baseUri(baseUrl)
                .redirects().follow(false);

        Response response = spec.get("/logout_page.php");

        System.out.println("--- RESPONSE ---");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Body: " + response.asString());
        System.out.println("Cookies: " + response.getCookies());
        System.out.println("=================");

        return new LoginResponse(response);
    }
}
