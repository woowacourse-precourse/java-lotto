package lotto.util;

import lotto.exception.IllegalArgumentError;

public class Util {

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);

        } catch (Exception e) {
            throw new IllegalArgumentError("you're input is not integer");
        }
    }
}
