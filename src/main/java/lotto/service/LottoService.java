package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.winning.LottoResults;
import lotto.domain.winning.Purchaser;
import lotto.domain.winning.WinningNumbers;
import lotto.view.input.LottoScanner;
import lotto.view.output.LottoPrinter;

public class LottoService {

    private final LottoStore lottoStore;
    private final LottoMachine lottoMachine;
    private final LottoScanner lottoScanner;
    private final LottoPrinter lottoPrinter;

    public LottoService(
            LottoStore lottoStore,
            LottoMachine lottoMachine,
            LottoScanner lottoScanner,
            LottoPrinter lottoPrinter) {
        this.lottoStore = lottoStore;
        this.lottoMachine = lottoMachine;
        this.lottoScanner = lottoScanner;
        this.lottoPrinter = lottoPrinter;
    }

    public void lottery() {
        try {
            lottoPrinter.printGuideMessageForPurchase();
            String money = lottoScanner.number();

            Purchaser purchaser = lottoStore.lottos(money);
            lottoPrinter.printTheNumberOfLottos(purchaser.numberOfPurchasedLottos());
            lottoPrinter.printLottoNumbers(purchaser.purchasedLottosFormat());

            lottoPrinter.printGuideMessageForWinningNumber();
            String winningNumber = lottoScanner.formattedNumber();

            lottoPrinter.printGuideMessageForBonusNumber();
            String bonusNumber = lottoScanner.number();

            WinningNumbers winningNumbers = lottoMachine.winningNumbers(winningNumber, bonusNumber);
            LottoResults lottoResults = purchaser.lottoResults(winningNumbers);
            double rateOfReturn = purchaser.rateOfReturn(lottoResults);

            lottoPrinter.printWinningStatistics(lottoResults.resultFormat(), rateOfReturn);
        } catch (IllegalArgumentException e) {
            lottoPrinter.printError(e.getMessage());
        }
    }
}
