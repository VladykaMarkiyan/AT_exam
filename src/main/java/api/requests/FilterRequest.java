package api.requests;

public class FilterRequest {
    private String name;
    private String query;

    public FilterRequest(String name, String query) {
        this.name = name;
        this.query = query;
    }

    public String getName() { return name; }
    public String getQuery() { return query; }
}
