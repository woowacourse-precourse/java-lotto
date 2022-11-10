package lotto;

public class LottoMachine {
    private static final int MIN_MONEY = 1000;
    private static final String MIN_MONEY_ERROR_MESSAGE = "[ERROR] 구입금액은 1000원 이상부터 가능합니다.";

    private int money;

    public LottoMachine(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateMinMoney(money);
    }

    private void validateMinMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
        }
    }
}
