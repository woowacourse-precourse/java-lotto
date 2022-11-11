package lotto.controller;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.strategy.lottosissuancestrategy.AutoLottosIssuanceStrategy;
import lotto.domain.strategy.lottosissuancestrategy.LottosIssuanceStrategy;
import lotto.dto.LottosDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        OutputView.printPaymentInputMessage();
        Payment payment = InputView.inputPayment();
        LottosIssuanceStrategy lottosIssuanceStrategy = new AutoLottosIssuanceStrategy();
        
        final int numberOfLottoPurchased = payment.countOfPurchasedLotto();
        final Lottos lottos = lottosIssuanceStrategy.issueLottos(numberOfLottoPurchased);
        
        OutputView.printLottoIssuanceResults(new LottosDTO(lottos));
        
        WinningLottoNumbers winningLottoNumbers = InputView.inputWinningLottoNumbers();
        final List<LottoRank> lottoRanks = lottos.parseRanks(winningLottoNumbers);
    
        OutputView.printWinningStats(lottoRanks);
    
        final double yield = payment.calculateYield(lottoRanks);
        OutputView.printYield(yield);
    }
}
