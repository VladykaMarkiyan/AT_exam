package api.responses;

import io.restassured.response.Response;

public class FilterResponse {
    private int statusCode;
    private String filterId;

    public FilterResponse(Response response) {
        this.statusCode = response.getStatusCode();
        if (response.getBody() != null && response.jsonPath().getString("id") != null) {
            this.filterId = response.jsonPath().getString("id");
        }
    }

    public int getStatusCode() { return statusCode; }
    public String getFilterId() { return filterId; }
}
