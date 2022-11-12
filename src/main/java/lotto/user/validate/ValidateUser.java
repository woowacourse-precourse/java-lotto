package lotto.user.validate;

import java.util.regex.Pattern;
import lotto.user.domain.User;

public class ValidateUser {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+[0-9]*$");
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validateMinAmount(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void validateOnlyNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
