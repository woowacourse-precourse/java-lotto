package lotto.domain.validator;

import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.validator.ErrorMessages.NEMERIC_ERROR_MESSAGE;
import static lotto.domain.validator.ErrorMessages.DIVIDED_ERROR_MESSAGE;

public class MoneyValidator extends Validator {
    private static boolean isNumeric(String moneyInput) {
        for (int index = 0; index < moneyInput.length(); index++) {
            if (!Character.isDigit(moneyInput.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDividedByLottoPrice(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if (money == 0 || money % LOTTO_PRICE.getValue() != 0) {
            return false;
        }
        return true;
    }

    public static void validate(String moneyInput) {
        if (!isNumeric((moneyInput))) {
            throw new IllegalArgumentException(NEMERIC_ERROR_MESSAGE.getMessage());
        }
        if (!isDividedByLottoPrice(moneyInput)) {
            String errorMessage = String.format(DIVIDED_ERROR_MESSAGE.getMessage(), LOTTO_PRICE.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
