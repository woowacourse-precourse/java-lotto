package lotto.domain;

import lotto.view.Input;

/**
 * 구매한 금액의 유효성과 관련 기능을 책임지는 클래스
 */
public class PurchaseAmount {

    private static final int UNIT_PRICE = 1000;

    private static final String ERROR_INDIVISIBLE = "[ERROR] " + UNIT_PRICE + "원으로 나누어떨어지는 금액만 입력해주십시오.";
    private static final String ERROR_MIN_PRICE = "[ERROR] " + UNIT_PRICE + "원 이상의 금액만 입력해주십시오.";

    private final int purchaseAmount;

    public PurchaseAmount(int inputPurchaseAmount) {
        isValidate(inputPurchaseAmount);
        this.purchaseAmount = inputPurchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getUNIT_PRICE() {
        return UNIT_PRICE;
    }

    private void isValidate(int purchaseAmount) {
        isValidateDivisible(purchaseAmount);
        isValidateMinPrice(purchaseAmount);
    }

    private void isValidateDivisible(int purchaseAmount) {
        if (purchaseAmount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INDIVISIBLE);
        }
    }

    private void isValidateMinPrice(int purchaseAmount) {
        if (purchaseAmount < UNIT_PRICE) {
            throw new IllegalArgumentException(ERROR_MIN_PRICE);
        }
    }

    public double divideTotalMoneyByAmount(long totalMoney) {
        return 1.0 * totalMoney / purchaseAmount;
    }
}
