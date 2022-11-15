package lotto.domain;

public class PurchasingPrice {
    private static final int ZERO = 0;
    private static final String INVALID_PRICE = "[ERROR] 로또 구입 금액은 양의 정수이어야 합니다.";
    private static final String INVALID_COST = "[ERROR] 로또 구입 가격은 양의 정수여야 합니다.";

    private final int price;

    public PurchasingPrice(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price <= ZERO || price % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    public int calculatePurchasableLottoCounts(int ticketCount) {
        if (ticketCount <= ZERO) {
            throw new IllegalArgumentException(INVALID_COST);
        }
        return price / ticketCount;
    }
}
