package lotto.service;

import java.util.Map;
import lotto.controller.dto.LottoPurchaseDto;
import lotto.controller.dto.PaymentAmountDto;
import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerStatistics;

public class LottoService {

    public LottoPurchaseDto purchaseLotto(PaymentAmountDto dto) {
        int paymentAmount = dto.getPaymentAmount();
        return new LottoPurchaseDto(paymentAmount);
    }

    public WinnerStatistics calculateWinnerStatistics(WinnerNumberDto winnerNumberDto, LottoPurchaseDto lottoDto) {
        return new WinnerStatistics(winnerNumberDto, lottoDto);
    }

    public ProfitRate calculateProfitRate(Map<Integer, Integer> statisticsStore) {
        return new ProfitRate(statisticsStore);
    }
}
