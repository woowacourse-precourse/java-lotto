package lotto.domain;

import lotto.view.InputView;

public class Consumer {
    private final static int PURCHASE_UNIT = 1000;

    public Consumer() {
        InputView input = new InputView();
        int purchasePrice = input.readPurchasePrice();
        validatePrice(purchasePrice);
    }

    private void validatePrice(int price) {
        if (price < PURCHASE_UNIT || price % PURCHASE_UNIT != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다. (최소 금액 1,000원)");
            throw new IllegalArgumentException();
        }
    }
}
