package lotto.lottoShop;

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
        if (purchaseAmount == ZERO.getIntValue() || purchaseAmount > HUNDRED_THOUSAND.getIntValue()) {
            throw new IllegalArgumentException(PURCHASE_RANGE_ERROR.getMessage());
        }
    }

    private void validatePurchaseThousandModular(int purchaseAmount) {
        if (purchaseAmount % THOUSAND.getIntValue() != ZERO.getIntValue()) {
            throw new IllegalArgumentException(PURCHASE_THOUSAND_MODULAR_ERROR.getMessage());
        }
    }
}
