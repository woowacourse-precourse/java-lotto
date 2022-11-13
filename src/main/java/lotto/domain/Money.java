package lotto.domain;

public class Money {

    private static final String NEGATIVE_AMOUNT_EXCEPTION_MESSAGE = "금액은 음수이면 안됩니다";

    private final int amount;

    public Money(int amount) {
        validateGreaterThanZero(amount);
        this.amount = amount;
    }

    private void validateGreaterThanZero(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }

    public boolean hasChangesWith(int price) {
        return amount % price != 0;
    }

    public int countAffordableFor(int price) {
        return amount / price;
    }
}
