package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private static final String MONEY_ERROR_MESSAGE = "구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
        }
    }

    public int getTicketCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
