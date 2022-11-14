package lotto;

import static lotto.util.Validator.validatePositiveNumber;
import static lotto.util.Validator.validateUnitStandard;

public class Quantity {

    private static final int UNIT_STANDARD = 1_000;

    private final int number;

    public Quantity(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
        validateUnitStandard(purchaseAmount);
        this.number = calculateQuantity(purchaseAmount);
    }

    public int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / UNIT_STANDARD;
    }

    public int getNumber() {
        return number;
    }
}
