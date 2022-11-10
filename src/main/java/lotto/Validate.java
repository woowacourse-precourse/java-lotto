package lotto;

import constant.Invalid;

import java.util.regex.Pattern;

public class Validate {
    private static final Pattern intPattern = Pattern.compile("[0-9]+");
    public void validNull(String input) {
        if (input == null) {
            Invalid.NULL.throwException();
        }
    }

    public void validInt(String input) {
        if (!intPattern.matcher(input).matches()) {
            Invalid.NOT_INT.throwException();
        }
    }
}
