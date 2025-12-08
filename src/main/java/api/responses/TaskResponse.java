package api.responses;

import io.restassured.response.Response;

public class TaskResponse {
    private int statusCode;
    private String taskId;

    public TaskResponse(Response response) {
        this.statusCode = response.getStatusCode();
        if (response.getBody() != null && response.jsonPath().getString("id") != null) {
            this.taskId = response.jsonPath().getString("id");
        }
    }

    public int getStatusCode() { return statusCode; }
    public String getTaskId() { return taskId; }
}
