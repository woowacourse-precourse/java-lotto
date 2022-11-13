package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoStore {
    private static InputView inputView;
    private static OutputView outputView;

    public LottoStore() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playLottoGame() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        int numberOfLottosPurchased = purchaseAmount.getNumberOfLottoPurchased();

        PurchaseLottos purchaseLottos = setPurchaseLottos(numberOfLottosPurchased);
        List<Lotto> lottos = purchaseLottos.getPurchaseLottos();

        printPurchaseInform(numberOfLottosPurchased, lottos);

        Lotto winningNumbers = enterWinningNumbers();
        BonusNumber bonusNumber = enterBonusNumbers(winningNumbers);

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, winningNumbers, bonusNumber.getBonusNumber());

        printWinningStatics(winningStatisticsCalculator.getWinningHistory());
        printRateOfReturn(winningStatisticsCalculator.getRateOfReturn());
    }

    private PurchaseAmount setPurchaseAmount() {
        return new PurchaseAmount(inputView.enterAmount());
    }

    private PurchaseLottos setPurchaseLottos(int numberOfLottoPurchased) {
        return new PurchaseLottos(numberOfLottoPurchased);
    }

    private void printPurchaseInform(int numberOfLottosPurchased, List<Lotto> lottos) {
        outputView.printNumberOfLottosPurchased(numberOfLottosPurchased);
        outputView.printLottosList(lottos);
    }

    private Lotto enterWinningNumbers() {
        return new Lotto(inputView.enterWinningNumber());
    }

    private BonusNumber enterBonusNumbers(Lotto winningNumbers) {
        return new BonusNumber(inputView.enterBonusNumber(), winningNumbers);
    }

    private void printWinningStatics(HashMap<WinningHistory, Integer> winningHistories) {
        outputView.printStartStatics();
        for (WinningHistory winningHistory : winningHistories.keySet()) {
            outputView.printStatics(winningHistory.getStaticsMessage(winningHistories.get(winningHistory)));
        }
    }

    private void printRateOfReturn(double rateOfReturn) {
        outputView.printRateOfReturn(rateOfReturn);
    }
}
