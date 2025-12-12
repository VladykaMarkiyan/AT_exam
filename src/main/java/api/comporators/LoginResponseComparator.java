package api.comporators;

import api.responses.LoginResponse;

public class LoginResponseComparator {

    public static boolean compare(LoginResponse expected, LoginResponse actual) {
        if (expected == null || actual == null) return false;

        boolean statusMatch = expected.getStatusCode() == actual.getStatusCode();
        boolean cookieMatch = (expected.getCookie("PHPSESSID") == null ? actual.getCookie("PHPSESSID") == null :
                expected.getCookie("PHPSESSID").equals(actual.getCookie("PHPSESSID")));

        return statusMatch && cookieMatch;
    }
}
