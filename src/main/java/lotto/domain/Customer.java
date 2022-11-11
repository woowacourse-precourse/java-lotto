package lotto.domain;

public class Customer {

    private Integer amount;
    private LottoTicket lottoTicket;

    public Customer(Integer amount) {
        this.amount = amount;
    }

    public void buyLottoTicketTo(LottoSeller lottoSeller) {
        lottoTicket = lottoSeller.sell(amount);
        spendAll();
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    private void spendAll() {
        amount = 0;
    }
}
