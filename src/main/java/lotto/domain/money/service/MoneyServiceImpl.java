package lotto.domain.money.service;

import lotto.domain.money.Money;
import lotto.global.utils.convert.ConvertUtils;

public class MoneyServiceImpl implements MoneyService{


    @Override
    public Money createMoney(String inputMoney) {
        final Integer initMoney = ConvertUtils.convertStringToInteger(inputMoney);
        return Money.create(initMoney);
    }
}
