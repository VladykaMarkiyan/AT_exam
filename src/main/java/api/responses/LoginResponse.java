package api.responses;

import io.restassured.response.Response;

public class LoginResponse {
    private Response response;

    public LoginResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getCookie(String name) {
        return response.getCookie(name);
    }

    public Response getRawResponse() {
        return response;
    }


}
