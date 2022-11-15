package lotto.domain;

import lotto.enumeration.NumberType;

public class PrizeNumber {

    private final Integer prizeNumber;
    private final NumberType numberType;

    public PrizeNumber(Integer prizeNumber, NumberType numberType) {
        this.prizeNumber = prizeNumber;
        this.numberType = numberType;
    }

    public boolean isNormal() {
        if (this.numberType == NumberType.NORMAL) {
            return true;
        }
        return false;
    }

    public int getPrizeNumber() {
        return this.prizeNumber;
    }

    public NumberType getNumberType() {
        return this.numberType;
    }

    public boolean isBonus() {
        if (this.numberType == NumberType.BOUNS) {
            return true;
        }
        return false;
    }
}
