package lotto.domain.money.service;

import lotto.domain.money.Money;

public class MoneyServiceImpl implements MoneyService{

    private final MoneyFactory moneyFactory;

    public MoneyServiceImpl(MoneyFactory moneyFactory) {
        this.moneyFactory = moneyFactory;
    }

    @Override
    public Money createMoney(String inputMoney) {
        final Integer initMoney = moneyFactory.convertStringToInteger(inputMoney);
        return Money.create(initMoney);
    }
}
