package lotto.domain;

import java.util.List;

public class Customer {

    private Integer amount;
    private List<Lotto> lottoTicket;

    public Customer(Integer amount) {
        this.amount = amount;
    }

    public void buyLottoTicketTo(LottoSeller lottoSeller) {
        lottoTicket = lottoSeller.sell(amount);
        spendAll();
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }

    private void spendAll() {
        amount = 0;
    }
}
