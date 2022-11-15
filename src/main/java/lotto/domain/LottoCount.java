package lotto.domain;

import lotto.validate.HandlingInputException;

public class LottoCount {
    private int purchaseAmount;

    public LottoCount(String purchseAmount) {
        HandlingInputException handlingInputException = new HandlingInputException();

        handlingInputException.consistOnlyNumbers(purchseAmount);
        handlingInputException.checkRightRange(Integer.parseInt(purchseAmount));
        handlingInputException.checkRightUnit(Integer.parseInt(purchseAmount));
        this.purchaseAmount = Integer.parseInt(purchseAmount);
    }

    public int getLottoCount() {
        return purchaseAmount / 1000;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
