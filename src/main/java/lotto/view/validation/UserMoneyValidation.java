package lotto.view.validation;

import lotto.domain.LottoEnum;

public class UserMoneyValidation {
    private static final int REMAINDER_ZERO = 0;
    private static final String NUMBER_REGEXP = "^[0-9]+$";

    public static void validate(String userAmount) {
        validateOnlyNumber(userAmount);
        validateUnits(userAmount);
    }

    private static void validateUnits(String userAmount) {
        if ((Integer.parseInt(userAmount) % LottoEnum.PRICE.getValue()) != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.UNITS.toString());
        }
    }

    private static void validateOnlyNumber(String userAmount) {
        if (!userAmount.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBER.toString());
        }
    }
}
