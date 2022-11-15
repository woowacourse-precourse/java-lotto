package lotto.presentation.view.validate;

import constants.ExceptionMessage;
import java.util.regex.Pattern;

public class LottoReaderValidator {

    private final static String COMMA_SEPARATOR_ARRAY_PATTERN =
            "^[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}$";

    public static void validateNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_NUMBER);
        }
    }

    public static void validateCommaSeparatorArray(String commaArray) {
        if (!Pattern.matches(COMMA_SEPARATOR_ARRAY_PATTERN, commaArray)) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_COMMA_ARRAY);
        }
    }

}
