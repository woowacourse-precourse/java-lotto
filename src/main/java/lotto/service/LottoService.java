package lotto.service;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTicket;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;

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

    public LottoMachine draw(LottoDto lottoDto) {
        return new LottoMachine(
                new Lotto(lottoDto.getWinningNumbers()),
                LottoNumber.valueOf(lottoDto.getBonusNumber())
        );
    }

    public LottoResultDto check(Customer customer, LottoMachine lottoMachine) {
        LottoResult result = customer.check(lottoMachine);
        return new LottoResultDto(result.calculateProfitRatio(), result.value());
    }
}
