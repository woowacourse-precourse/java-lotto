package lotto;

public class Money {
    private static final int MIN_MONEY = 1000;
    private static final String AMOUNT_IS_NOT_UNDER_1000_MESSAGE = "[ERROR] 로또 구입 금액이 1,000원 미만이 될 수 없습니다.";

    private int amount;

    public Money(int amount) {
        validateAmountIsNotUnder1000(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateAmountIsNotUnder1000(int amount) {
        if (amount < MIN_MONEY) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_UNDER_1000_MESSAGE);
        }
    }
}