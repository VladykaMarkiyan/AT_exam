package data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"wrongUser", "wrongPass", false},
                {"administrator", "wrongPass", false},
                {"administrator", "root", true}
        };
    }
}
