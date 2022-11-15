package lotto.domain;

public class PurchaseMoney {
    private final String PURCHASE_MONEY_MUST_OVER_1000 = "구매 금액은 1000원 이상을 입력해주세요.";
    private final String PURCHASE_MONEY_UNIT_IS_1000 = "구매 금액은 1000원 단위로 입력해주세요.";
    private final int LOTTO_PRICE_UNIT = 1000;
    private final int price;

    public PurchaseMoney(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MUST_OVER_1000);
        }
        if (price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_UNIT_IS_1000);
        }
    }

    public int getPrice() {
        return this.price;
    }
}
