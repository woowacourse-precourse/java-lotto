package lotto.domain;

import lotto.view.Input;

public class PurchaseMoney {
    private final int LOTTO_PRICE_UNIT = 1000;
    private final int price;

    public PurchaseMoney(int price){
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE_UNIT){
            throw new IllegalArgumentException("구매 금액은 1000원 이상을 입력해주세요.");
        }
        if (price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해주세요.");
        }
    }
}
