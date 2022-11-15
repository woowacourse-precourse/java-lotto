package lotto.view.vlidation;

import lotto.view.exception.CantBlankOrNullInputException;
import lotto.view.exception.CantDivideByThousandToZeroException;
import lotto.view.exception.CantFirstNumberZeroException;
import lotto.view.exception.OnlyNumberConsistBetweenOneToNineInputException;

import java.util.Objects;

import static lotto.domain.LottoConfig.THOUSAND;

public class InputMoneyValidator {

    private InputMoneyValidator() {
    }

    private static final Integer ZERO = 0;
    private static final String NUMBER_REGEXP = "\\d+$";
    private static final String ZERO_AT_FIRST = "0\\d+";

    public static void validate(String input) {
        validateBlank(input);
        validateFirstNumberZero(input);
        validateOnlyNumber(input);
        validateDividedByThousand(input);
        validateNumberBetweenZeroToNine(input);
    }

    private static void validateOnlyNumber(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new OnlyNumberConsistBetweenOneToNineInputException();

        }
    }

    private static void validateDividedByThousand(String input) {
        if (isDividedByThousand(input)) {
            throw new CantDivideByThousandToZeroException();
        }
    }

    private static boolean isDividedByThousand(String input) {
        return (Integer.parseInt(input) % THOUSAND.getNumber()) != ZERO;
    }

    public static void validateNumberBetweenZeroToNine(String input) {
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
    private static void validateFirstNumberZero(String input) {
        if (input.matches(ZERO_AT_FIRST)) {
            throw new CantFirstNumberZeroException();
        }
    }
}
