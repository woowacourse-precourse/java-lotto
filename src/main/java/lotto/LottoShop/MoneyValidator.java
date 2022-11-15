package lotto.LottoShop;

import static lotto.Enum.Constant.*;
import static lotto.Enum.Error.*;

public class MoneyValidator {
    public MoneyValidator() {
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validatePurchaseOnlyNumber(purchaseAmount);

        int purchaseAmountToInt = Integer.parseInt(purchaseAmount);

        validatePurchaseRange(purchaseAmountToInt);

        validatePurchaseThousandModular(purchaseAmountToInt);
    }

    private void validatePurchaseOnlyNumber(String purchaseAmount) {
        if (!purchaseAmount.matches(REGEX_ONLY_NUMBER.getValue())) {
            throw new IllegalArgumentException(PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }
    }

    private void validatePurchaseRange(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PURCHASE_MIN.getIntValue() || purchaseAmount > LOTTO_PURCHASE_MAX.getIntValue()) {
            throw new IllegalArgumentException(PURCHASE_RANGE_ERROR.getMessage());
        }
    }

    private void validatePurchaseThousandModular(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PURCHASE_MIN.getIntValue() != THOUSAND_MODULAR_ZERO.getIntValue()) {
            throw new IllegalArgumentException(PURCHASE_THOUSAND_MODULAR_ERROR.getMessage());
        }
    }
}
