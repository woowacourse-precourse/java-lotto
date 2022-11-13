package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private static final String NOT_DIVIDED_BY_LOTTO_PRICE_ERROR = "구입 금액은 1000원으로 나누어 떨어져야 합니다.";
    private static final String NEGATIVE_MONEY_ERROR = "구입 금액은 음수일 수 없습니다.";

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        validateDividedByLottoPrice(money);
        validateNotNegative(money);
    }

    private void validateNotNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_ERROR);
        }
    }

    private void validateDividedByLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE_ERROR);
        }
    }

    public int getTicketCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
