package lotto.domain;

public class Customer {
    private Money amount;
    private LottoTicket lottoTicket;

    public Customer(Money amount) {
        this(amount, new LottoTicket());
    }

    public Customer(Money amount, LottoTicket lottoTicket) {
        this.amount = amount;
        this.lottoTicket = lottoTicket;
    }

    public void buyLottoTicketTo(LottoSeller lottoSeller) {
        lottoTicket = lottoSeller.sell(amount);
        spendAll();
    }

    private void spendAll() {
        amount = Money.ZERO;
    }

    public LottoResult check(LottoMachine lottoMachine) {
        return lottoMachine.check(lottoTicket);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
