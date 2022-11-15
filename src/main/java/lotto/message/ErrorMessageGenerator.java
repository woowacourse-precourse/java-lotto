package lotto.message;

import lotto.condition.Condition;

public class ErrorMessageGenerator {

    private static final String ERROR_MESSAGE_TEMPLATE = "[ERROR]";

    private ErrorMessageGenerator() {
    }

    public static String getErrorMessage(Condition condition) {
        return ERROR_MESSAGE_TEMPLATE + condition.getErrorMessage();
    }
}
