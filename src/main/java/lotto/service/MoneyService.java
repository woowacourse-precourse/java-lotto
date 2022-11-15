package lotto.service;

import lotto.domain.Money;
import lotto.repository.MoneyRepository;

public class MoneyService {

    private final MoneyRepository moneyRepository;

    public MoneyService(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    public void saveMoney(Money money) {
        moneyRepository.save(money);
    }

    public Money findMoney() {
        return moneyRepository.findMoney();
    }
}
