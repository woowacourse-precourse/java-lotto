package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningHistory;
import lotto.domain.WinningStatisticsCalculator;
import lotto.domain.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoStore {
    private static int amount;
    private static List<Lotto> lottos;
    private static Lotto winningNumbers;
    private static BonusNumber bonusNumber;

    public void playLottoGame() {
        try {
            purchaseLotto();
            setWinningNumbers();
            showWinningStatics();
        } catch (NumberFormatException exception) {
            System.out.println(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void purchaseLotto() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        int numberOfLottosPurchased = purchaseAmount.getNumberOfLottoPurchased();
        amount = purchaseAmount.getAmount();

        PurchaseLottos purchaseLottos = setPurchaseLottos(numberOfLottosPurchased);
        lottos = purchaseLottos.getPurchaseLottos();

        printPurchaseInform(numberOfLottosPurchased, lottos);
    }

    private void setWinningNumbers() {
        winningNumbers = setWinningNumber();
        bonusNumber = setBonusNumbers(winningNumbers);
    }

    private void showWinningStatics() {
        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, winningNumbers, bonusNumber.getBonusNumber());

        HashMap<WinningHistory, Integer> winningHistories = winningStatisticsCalculator.getWinningHistory();
        String rateOfReturn = winningStatisticsCalculator.calculateRateOfReturn(amount);

        OutputView.printStatics(winningHistories);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private PurchaseAmount setPurchaseAmount() {
        return new PurchaseAmount(InputView.enterAmount());
    }

    private PurchaseLottos setPurchaseLottos(int numberOfLottoPurchased) {
        return new PurchaseLottos(numberOfLottoPurchased);
    }

    private void printPurchaseInform(int numberOfLottosPurchased, List<Lotto> lottos) {
        OutputView.printNumberOfLottosPurchased(numberOfLottosPurchased);
        OutputView.printLottosList(lottos);
    }

    private Lotto setWinningNumber() {
        return new Lotto(InputView.enterWinningNumber());
    }

    private BonusNumber setBonusNumbers(Lotto winningNumbers) {
        return new BonusNumber(InputView.enterBonusNumber(), winningNumbers);
    }
}
