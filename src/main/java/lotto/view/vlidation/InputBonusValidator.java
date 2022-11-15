package lotto.view.vlidation;

import lotto.domain.Lotto;
import lotto.view.exception.CantBlankOrNullInputException;
import lotto.view.exception.CantDuplicatedNumberInputException;
import lotto.view.exception.CantFirstNumberZeroException;
import lotto.view.exception.OnlyNumberConsistBetweenOneToNineInputException;

import java.util.Objects;

public class InputBonusValidator {

    private static final String NUMBER_REGEXP = "\\d+$";
    private static final String ZERO_AT_FIRST = "0\\d+";

    private InputBonusValidator() {
    }

    public static void validate(String input) {
        validateBlank(input);
        validateIsNumber(input);
        validateFirstNumberZero(input);
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


    public static void validateDuplicateNumberInWinnerLottoNumbers(Lotto lotto, Integer bonus) {
        if (lotto.containBonusNumber(bonus)) {
            throw new CantDuplicatedNumberInputException();
        }
    }


    private static void validateFirstNumberZero(String input) {
        if (input.matches(ZERO_AT_FIRST)) {
            throw new CantFirstNumberZeroException();
        }
    }
}
