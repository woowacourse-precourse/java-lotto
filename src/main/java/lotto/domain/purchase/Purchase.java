package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private static final String PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    private final int purchaseAmount;


    public Purchase(final int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }



    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR);
        }
    }

    private int numOfLotto(int money) {
        int num = money / 1000;
        return num;
    }
}
