package api;

import api.requests.TaskRequest;
import api.responses.TaskResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class TaskAPI {
    private final String baseUrl;

    public TaskAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response createTask(String sessionId, String taskName, String description) {
        return RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .formParam("name", taskName)
                .formParam("description", description)
                .redirects().follow(false)
                .post("/task_create.php");
    }

}
