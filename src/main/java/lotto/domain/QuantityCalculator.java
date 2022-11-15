package lotto.domain;

import lotto.ConstValue;

public class QuantityCalculator {
    public static int calculateProperQuantity(int batAmount) {
        return batAmount / ConstValue.Numbers.PRICE_PER_LOTTO;
    }
}
