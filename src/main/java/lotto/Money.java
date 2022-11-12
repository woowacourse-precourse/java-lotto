package lotto;

public class Money {

    private final int amount;

    public Money(int amount) {
        validateGreaterThanZero(amount);
        this.amount = amount;
    }

    private void validateGreaterThanZero(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수이면 안됩니다");
        }
    }

    public boolean hasChangesWith(int price) {
        return amount % price != 0;
    }

    public int countAffordableFor(int price) {
        return amount / price;
    }
}
