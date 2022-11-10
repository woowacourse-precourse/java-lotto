package lotto.domain;

import java.util.List;

public class Customer {

    private Integer amount;
    private List<Lotto> lottos;

    public Customer(Integer amount) {
        this.amount = amount;
    }

    public void buy(LottoSeller lottoSeller) {
        lottos = lottoSeller.sell(amount);
        spendAll();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void spendAll() {
        amount = 0;
    }
}
