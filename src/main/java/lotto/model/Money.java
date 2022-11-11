package lotto.model;

public class Money {

    public static final String ERR_PURCHASE_AMOUNT = "[ERROR] 구매 금액은 1000원 단위여야 합니다. 예시) 7000(O), 15000(O), 6500(X)";
    private final int amount;
    public Money(int amount) {
        this.amount = amount;
        validate(amount);
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERR_PURCHASE_AMOUNT);
        }
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ERR_PURCHASE_AMOUNT);
        }
    }

    public int getNumberOfLottos() {
        return amount / Lotto.PRICE;
    }
}
