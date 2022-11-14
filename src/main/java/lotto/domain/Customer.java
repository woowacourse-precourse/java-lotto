package lotto.domain;

public class Customer {
    private static final String INVALID_TICKET_MESSAGE = "로또를 아직 구매하지 않았습니다.";

    private Integer amount;
    private LottoTicket lottoTicket;

    public Customer(Integer amount) {
        this.amount = amount;
    }

    public void buyLottoTicketTo(LottoSeller lottoSeller) {
        lottoTicket = lottoSeller.sell(amount);
        spendAll();
    }

    private void spendAll() {
        amount = 0;
    }

    public LottoResult check(LottoMachine lottoMachine) {
        if (lottoTicket == null) {
            throw new IllegalStateException(INVALID_TICKET_MESSAGE);
        }
        return lottoMachine.check(lottoTicket);
    }

    public LottoTicket getLottoTicket() {
        if (lottoTicket == null) {
            throw new IllegalStateException(INVALID_TICKET_MESSAGE);
        }
        return lottoTicket;
    }
}
