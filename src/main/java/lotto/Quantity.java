package lotto;

import static lotto.constant.StandardConstant.MONEY_UNIT_STANDARD;
import static lotto.util.Validator.validatePositiveNumber;
import static lotto.util.Validator.validateUnitStandard;

public class Quantity {

    private final int number;

    public Quantity(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
        validateUnitStandard(purchaseAmount);
        this.number = calculateQuantity(purchaseAmount);
    }

    public int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / MONEY_UNIT_STANDARD.getValue();
    }

    public int getNumber() {
        return number;
    }
}
