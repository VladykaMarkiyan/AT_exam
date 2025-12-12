package data;

import org.testng.annotations.DataProvider;

public class ProjectDataProvider {

    @DataProvider(name = "projectData")
    public static Object[][] projectData() {
        return new Object[][] {
                {"New Website", "Create new company website"},
                {"Game Engine", "Develop 2D engine"},
                {"Ecommerce Platform", "Build online shop platform"}
        };
    }
}
