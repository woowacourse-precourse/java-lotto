package lotto.domain;

import lotto.view.ErrorMessage;

public class Validator {
    public static void validateAmount(String amount) {
        isNumber(amount);
        isUnitOfThousand(Integer.parseInt(amount));
    }

    private static void isNumber(String amount) {
        if (amount.matches("^[^0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER_POSSIBLE.getMessage());
        }
    }

    private static void isUnitOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_THOUSAND_UNIT_POSSIBLE.getMessage());
        }
    }

}
