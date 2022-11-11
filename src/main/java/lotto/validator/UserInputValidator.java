package lotto.validator;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;
import lotto.constant.RegularExpression;

public class UserInputValidator {

    public static void validateStringIsNumeric(String userInput) {
        if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), userInput)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ALLOWED_ONLY_NUMERIC.getMessage());
        }
    }
}
