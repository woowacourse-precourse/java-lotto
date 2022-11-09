package lotto.user.validation;

import java.util.List;
import lotto.domain.LottoEnum;
import lotto.user.UserUtil;

public class UserValidation {
    private static final int AMOUNT_UNITS = 1000;
    private static final int REMAINDER_ZERO = 0;

    public static void validate(String userAmount) {
        validateUnits(userAmount);
    }
    public static void validateNumbers(String userInput) {
        validateNumberRange(userInput);
    }

    private static void validateNumberRange(String userInput) {
        List<Integer> userNumbers = UserUtil.convertUserInputToNumbers(userInput);
        boolean correctNumber = userNumbers.stream().allMatch(LottoEnum::isNumberInRange);
        if (!correctNumber) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.toString());
        }
    }

    private static void validateUnits(String userAmount) {
        if ((Integer.parseInt(userAmount) % AMOUNT_UNITS) != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.UNITS.toString());
        }
    }
}
