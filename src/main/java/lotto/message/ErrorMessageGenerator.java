package lotto.message;

import lotto.condition.Condition;

public class ErrorMessageGenerator {
    private ErrorMessageGenerator() {
    }

    public static String getErrorMessage(Condition condition) {
        return "[ERROR]" + condition.getErrorMessage();
    }
}
