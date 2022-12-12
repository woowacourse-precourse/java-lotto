package lotto.model;

public class LottoPurchaseAmount {
    public static final int LOTTO_PRICE = 1_000;
    private static final String INVALID_AMOUNT_MESSAGE = "구매 금액은 1000원으로 나눠 떨어져야 합니다.";
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
    }

    public int getNumberOfAvailableBuyLotto() {
        return amount / LOTTO_PRICE;
    }
}
