package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.strategy.lottosissuancestrategy.AutoLottosIssuanceStrategy;
import lotto.domain.strategy.lottosissuancestrategy.LottosIssuanceStrategy;
import lotto.dto.LottoRanksDTO;
import lotto.dto.LottosDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            Payment payment = inputPayment();
            playLottoDraw(payment);
        } catch (IllegalArgumentException exceptionRaised) {
            System.out.println(exceptionRaised.getMessage());
        }
    }
    
    private Payment inputPayment() {
        printPaymentInputMessage();
        return InputView.inputPayment();
    }
    
    private void printPaymentInputMessage() {
        OutputView.printPaymentInputMessage();
    }
    
    private void playLottoDraw(final Payment payment) {
        final Lottos lottos = issueLottos(payment, new AutoLottosIssuanceStrategy());
        
        printLottoIssuanceResults(lottos);
        printWinningResult(payment, lottoRanksDTO(lottos));
    }
    
    private Lottos issueLottos(final Payment payment, final LottosIssuanceStrategy lottosIssuanceStrategy) {
        return lottosIssuanceStrategy.issueLottos(countOfPurchasedLotto(payment));
    }
    
    private int countOfPurchasedLotto(final Payment payment) {
        return payment.countOfPurchasedLotto();
    }
    
    private void printLottoIssuanceResults(final Lottos lottos) {
        OutputView.printLottoIssuanceResults(new LottosDTO(lottos));
    }
    
    private LottoRanksDTO lottoRanksDTO(final Lottos lottos) {
        return new LottoRanksDTO(lottos, inputWinningLottoNumbers());
    }
    
    private WinningLottoNumbers inputWinningLottoNumbers() {
        return InputView.inputWinningLottoNumbers();
    }
    
    private void printWinningResult(final Payment payment, final LottoRanksDTO lottoRanksDTO) {
        OutputView.printWinningStats(lottoRanksDTO);
        OutputView.printYield(calculateYield(payment, lottoRanksDTO));
    }
    
    private double calculateYield(final Payment payment, final LottoRanksDTO lottoRanksDTO) {
        return payment.calculateYield(lottoRanksDTO.getLottoRanks());
    }
}
