package lotto;

import constant.Invalid;

public class Validate {
    public void validNull(String input) {
        if (input == null) {
            Invalid.NULL.throwException();
        }
    }
}
