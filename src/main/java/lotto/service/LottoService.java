package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.winning.WinningStatistics;
import lotto.domain.winning.PurchasedLottoTickets;
import lotto.domain.winning.LottoResults;
import lotto.domain.winning.WinningLotto;
import lotto.view.input.LottoScanner;
import lotto.view.output.LottoPrinter;

public class LottoService {

    private static final String PURCHASED_SUFFIX = "개를 구매했습니다.";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final LottoStore lottoStore;
    private final LottoMachine lottoMachine;
    private final LottoScanner lottoScanner;
    private final LottoPrinter lottoPrinter;

    public LottoService(LottoStore lottoStore, LottoMachine lottoMachine,
            LottoScanner lottoScanner, LottoPrinter lottoPrinter) {
        this.lottoStore = lottoStore;
        this.lottoMachine = lottoMachine;
        this.lottoScanner = lottoScanner;
        this.lottoPrinter = lottoPrinter;
    }

    public void lottery() {
        try {
            String money = money();
            PurchasedLottoTickets purchasedLottoTickets = purchasedLottoTickets(money);

            WinningLotto winningLotto = lottoMachine.winningLotto(
                    winningNumber(),
                    bonusNumber()
            );

            makeWinningResults(purchasedLottoTickets, winningLotto);
        } catch (IllegalArgumentException e) {
            lottoPrinter.printError(ERROR_MESSAGE_PREFIX + e.getMessage());
        }
    }

    private String money() {
        lottoPrinter.printGuideMessageForPurchase();
        return lottoScanner.number();
    }

    private PurchasedLottoTickets purchasedLottoTickets(String money) {
        PurchasedLottoTickets purchasedLottoTickets = lottoStore.lottoTickets(money);
        lottoPrinter.printTheNumberOfPurchaseLottos(
                purchasedLottoTickets.totalCounts(),
                PURCHASED_SUFFIX
        );
        lottoPrinter.printLottoNumbers(purchasedLottoTickets.toString());

        return purchasedLottoTickets;
    }

    private String bonusNumber() {
        lottoPrinter.printGuideMessageForBonusNumber();
        return lottoScanner.number();
    }

    private String winningNumber() {
        lottoPrinter.printGuideMessageForWinningNumber();
        return lottoScanner.formattedNumber();
    }

    private void makeWinningResults(PurchasedLottoTickets purchasedLottoTickets,
            WinningLotto winningLotto) {
        LottoResults lottoResults = purchasedLottoTickets.lottoResults(winningLotto);
        WinningStatistics winningStatistics = new WinningStatistics(
                purchasedLottoTickets,
                lottoResults
        );

        lottoPrinter.printWinningStatistics(winningStatistics);
    }
}