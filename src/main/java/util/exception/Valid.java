package util.exception;

import java.util.regex.Pattern;
import util.message.ErrorMessage;

public class Valid {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean isDigit(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            return false;
        }
        return true;
    }
}
