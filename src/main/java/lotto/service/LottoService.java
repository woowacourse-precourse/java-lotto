package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.winning.LottoResults;
import lotto.domain.winning.LottoPurchaser;
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
            String money = money();
            LottoPurchaser lottoPurchaser = lottoPurchaser(money);

            WinningNumbers winningNumbers = lottoMachine.winningNumbers(
                    winningNumber(),
                    bonusNumber()
            );

            winningResults(lottoPurchaser, winningNumbers);

        } catch (IllegalArgumentException e) {
            lottoPrinter.printError(e.getMessage());
        }
    }

    private String money() {
        lottoPrinter.printGuideMessageForPurchase();
        return lottoScanner.number();
    }

    private void winningResults(LottoPurchaser lottoPurchaser, WinningNumbers winningNumbers) {
        LottoResults lottoResults = lottoPurchaser.lottoResults(winningNumbers);
        double rateOfReturn = lottoPurchaser.rateOfReturn(lottoResults);
        lottoPrinter.printWinningStatistics(lottoResults.resultFormat(), rateOfReturn);
    }

    private String bonusNumber() {
        lottoPrinter.printGuideMessageForBonusNumber();
        return lottoScanner.number();
    }

    private String winningNumber() {
        lottoPrinter.printGuideMessageForWinningNumber();
        return lottoScanner.formattedNumber();
    }

    private LottoPurchaser lottoPurchaser(String money) {
        LottoPurchaser lottoPurchaser = lottoStore.lottos(money);
        lottoPrinter.printTheNumberOfLottos(lottoPurchaser.numberOfPurchasedLottos());
        lottoPrinter.printLottoNumbers(lottoPurchaser.purchasedLottosFormat());
        return lottoPurchaser;
    }
}
