package api.responses;

import io.restassured.response.Response;

public class LoginResponse {
    private int statusCode;
    private String sessionId;

    public LoginResponse(Response response) {
        this.statusCode = response.getStatusCode();
        this.sessionId = response.getCookie("PHPSESSID");
    }

    public int getStatusCode() { return statusCode; }
    public String getSessionId() { return sessionId; }
}
