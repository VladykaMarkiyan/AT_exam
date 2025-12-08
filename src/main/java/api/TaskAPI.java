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

    public TaskResponse createTask(String sessionId, TaskRequest task) {
        RequestSpecification req = RestAssured.given()
                .baseUri(baseUrl)
                .cookie("PHPSESSID", sessionId)
                .formParam("name", task.getName())
                .formParam("description", task.getDescription())
                .redirects().follow(false);

        Response response = req.post("/manage_proj_create_page.php");
        return new TaskResponse(response);
    }
}
