package lotto.validator;

import java.util.regex.Pattern;
import lotto.constant.Constants;
import lotto.constant.ErrorMessage;
import lotto.constant.RegularExpression;

public class UserInputValidator {

    public static void validateStringIsNumeric(String userInput) {
        if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), userInput)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ALLOWED_ONLY_NUMERIC.getMessage());
        }
    }

    public static void validateWinningLottoNumberComplyWithRule(String userInput) {
        for (String splitInput : userInput.split(Constants.WINNING_LOTTO_NUMBER_INPUT_SEPARATOR)) {
            if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), splitInput)) {
                throw new IllegalArgumentException(
                        ErrorMessage.USER_INPUT_DOES_NOT_COMPLY_WITH_RULE_FOR_WINNING_LOTTO_NUMBER.getMessage()
                );
            }
        }
    }
}
