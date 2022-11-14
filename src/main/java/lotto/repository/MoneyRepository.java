package lotto.repository;

import lotto.domain.Money;

public class MoneyRepository {

    private static Money money;

    public Money save(Money money) {
        this.money = money;
        return money;
    }

    public Money findMoney() {
        return money;
    }
}
