package lotto.service;

import lotto.controller.dto.LottoPurchaseDto;
import lotto.controller.dto.PaymentAmountDto;
import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.WinnerStatistics;

public class LottoService {

    public LottoPurchaseDto purchaseLotto(PaymentAmountDto dto) {
        int paymentAmount = dto.getPaymentAmount();
        return new LottoPurchaseDto(paymentAmount);
    }

    public WinnerStatistics calculateWinnerStatistics(WinnerNumberDto winnerNumberDto, LottoPurchaseDto lottoDto) {
        return new WinnerStatistics(winnerNumberDto, lottoDto);
    }
}
