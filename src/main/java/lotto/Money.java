package lotto;

import lotto.exception.LottoInputException;

public class Money {
    private final int money;

    public Money(int money) {
        checkMoney(money);
        this.money = money;
    }

    private void checkMoney(int money) {
        try {
            isDivided(money);
        } catch (LottoInputException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void isDivided(int money) {
        if (money % 1000 != 0) {
            throw new LottoInputException("[ERROR] 1000단위의 금액만 입력할 수 있습니다.");
        }
    }
}
