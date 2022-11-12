package lotto.model;

import static lotto.validator.MoneyValidator.hasValidPaidMoney;

import java.util.List;

public class Customer {
    private final int paidMoney;
    private final List<Lotto> lottos;

    public Customer(
            int paidMoney,
            List<Lotto> lottos
    ) {
        hasValidPaidMoney(paidMoney);
        this.paidMoney = paidMoney;
        this.lottos = lottos;
    }
}
