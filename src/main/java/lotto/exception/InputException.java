package lotto.exception;

import java.util.regex.Pattern;

public class InputException {

    public static void validPurchaseAmount(String money) {
        if (!Pattern.matches("^[0-9]*$", money)) {
            throw new IllegalArgumentException();
        }
    }

}
