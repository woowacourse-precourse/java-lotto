package lotto.domain;

import lotto.domain.errorenum.LottoError;

public class Money {
    private static final int MIN_AMOUNT = 1000;
    private static final String MIN_MONEY_LIMIT = String.format("%d원 이상 구매해야 합니다.", MIN_AMOUNT);
    private static final String MONEY_CHANGE_LEFT = String.format("잔돈이 발생하였습니다. %d원 단위로 입력해주세요.", MIN_AMOUNT);
    private final int money;

    public Money(int money) {
        validateAbleToBuyAtLeastOne(money);
        validateChangeLeft(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int calculateBoughtLottoCount() {
        return money / MIN_AMOUNT;
    }

    private void validateAbleToBuyAtLeastOne(int money) {
        if (money < MIN_AMOUNT) {
            throw new IllegalArgumentException(LottoError.printError(MIN_MONEY_LIMIT));
        }
    }

    private void validateChangeLeft(int money) {
        if (money % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(LottoError.printError(MONEY_CHANGE_LEFT));
        }
    }
}
