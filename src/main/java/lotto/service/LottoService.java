package lotto.service;

import lotto.domain.Customer;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTicket;
import lotto.dto.LottoInformationDto;

public class LottoService {

    private final LottoSeller lottoSeller;

    public LottoService(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public LottoInformationDto buy(Customer customer) {
        customer.buyLottoTicketTo(lottoSeller);
        LottoTicket lottoTicket = customer.getLottoTicket();
        return new LottoInformationDto(lottoTicket.value());
    }
}
