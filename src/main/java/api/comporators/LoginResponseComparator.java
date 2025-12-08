package api.comporators;

import api.responses.LoginResponse;

public class LoginResponseComparator {

    public static boolean compare(LoginResponse actual, LoginResponse expected) {
        return actual.getStatusCode() == expected.getStatusCode();
    }
}
