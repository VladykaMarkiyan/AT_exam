package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TaskAPI {

    private final String baseUrl;

    public TaskAPI(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response createTask(String token, String taskName, String taskDescription) {
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUrl)
                .formParam("task_name", taskName)
                .formParam("task_description", taskDescription)
                .header("Cookie", "PHPSESSID=" + token)
                .redirects().follow(false);
        return request.post("/manage_proj_create_page.php");
    }
}
