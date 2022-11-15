package lotto.util;


public class ValidationUtility {
    private ValidationUtility() {}
    private static void assertError(String msg) {
        throw new IllegalArgumentException("[ERROR] " + msg);
    }
    protected static void validationTest(String input, int type) {
        if (type == Type.AMOUNT.getValue()) {

        }

        if (type == Type.LOTTO.getValue()) {

        }
        if (type == Type.BONUS.getValue()) {

        }

    }

}
