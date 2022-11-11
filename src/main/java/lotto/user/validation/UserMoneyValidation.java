package lotto.user.validation;

import lotto.domain.LottoEnum;

public class UserMoneyValidation {
    private static final int REMAINDER_ZERO = 0;

    public static void validate(String userAmount) {
        validateUnits(userAmount);
    }

    private static void validateUnits(String userAmount) {
        if ((Integer.parseInt(userAmount) % LottoEnum.PRICE.getValue()) != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.UNITS.toString());
        }
    }
}
