package lotto.domain;

import lotto.enumeration.NumberType;

public class PrizeNumber {

    private final Integer prizeNumber;
    private final NumberType numberType;

    public PrizeNumber(Integer prizeNumber, NumberType numberType) {
        this.prizeNumber = prizeNumber;
        this.numberType = numberType;
    }
}
