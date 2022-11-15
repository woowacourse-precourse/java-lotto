package lotto.view.vlidation;

import lotto.view.exception.CantBlankOrNullInputException;
import lotto.view.exception.OnlyNumberConsistBetweenOneToNineInputException;

import java.util.Objects;

public class InputBonusValidator {

    private static final String NUMBER_REGEXP = "\\d+$";

    private InputBonusValidator() {
    }

    public static void validate(String input) {
        validateIsNumber(input);
        validateBlank(input);
    }

    private static void validateIsNumber(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new OnlyNumberConsistBetweenOneToNineInputException();
        }
    }

    public static void validateBlank(final String input) {
        if (isBlank(input)) {
            throw new CantBlankOrNullInputException();
        }
    }

    private static boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
