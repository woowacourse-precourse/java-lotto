package lotto.service;

import static lotto.Constants.MINIMUM_PURCHASE_AMOUNT;
import static lotto.Constants.PURCHASE_AMOUNT_IS_NOT_DIVIDED_ERROR_MESSAGE;
import static lotto.Constants.PURCHASE_AMOUNT_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static lotto.Constants.PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR_MESSAGE;

public class UserLottoService {
    private static UserLottoService instance;

    private UserLottoService() {
    }

    public static UserLottoService getInstance() {
        if (instance == null) {
            instance = new UserLottoService();
        }
        return instance;
    }

    public void validate(String purchaseAmount) {
        boolean isNumber = purchaseAmount.chars().allMatch(Character::isDigit);
        if (!isNumber) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        int amount = Integer.parseInt(purchaseAmount);
        if (amount < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }
        if (amount % MINIMUM_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_DIVIDED_ERROR_MESSAGE);
        }
    }
}
