package lotto.domain;

import java.util.Optional;

public class Customer {
    private static final String INVALID_TICKET_MESSAGE = "로또를 아직 구매하지 않았습니다.";

    private Integer amount;
    private Optional<LottoTicket> lottoTicket = Optional.empty();

    public Customer(Integer amount) {
        this.amount = amount;
    }

    public void buyLottoTicketTo(LottoSeller lottoSeller) {
        lottoTicket = Optional.of(lottoSeller.sell(amount));
        spendAll();
    }

    private void spendAll() {
        amount = 0;
    }

    public LottoResult check(LottoMachine lottoMachine) {
        return lottoMachine.check(lottoTicket.orElseThrow(() -> new IllegalStateException(INVALID_TICKET_MESSAGE)));
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket.orElseThrow(() -> new IllegalStateException(INVALID_TICKET_MESSAGE));
    }
}
