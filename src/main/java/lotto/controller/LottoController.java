package lotto.controller;

import lotto.domain.*;
import lotto.view.ConsoleView;

import java.util.List;

public class LottoController {
    private PurchasedLottos purchasedLottos;
    private WinningLotto winningLotto;
    private WinningStatistics winningStatistics;

    public void process() {
        purchaseLotto();
        showPurchasedLottos();
        setWinningLotto();
        createWinningStatistics();
        showWinningResult();
    }

    private void purchaseLotto() {
        int payment = ConsoleView.inputPurchasePrice();
        purchasedLottos = new PurchasedLottos(payment);
    }

    private void showPurchasedLottos() {
        int amount = purchasedLottos.getLottos().size();
        ConsoleView.printBlankLine();
        ConsoleView.printPurchaseAmount(amount);
        ConsoleView.printPurchasedLottos(purchasedLottos);
    }

    private void setWinningLotto() {
        Lotto lotto = createWinningNumbers();
        int bonusNumber = createBonusNumber();
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    private Lotto createWinningNumbers() {
        ConsoleView.printBlankLine();
        List<Integer> numbers = ConsoleView.inputWinningNumbers();
        return new Lotto(numbers);
    }

    private int createBonusNumber() {
        ConsoleView.printBlankLine();
        return ConsoleView.inputBonusNumber();
    }

    private void createWinningStatistics() {
        winningStatistics =  new WinningStatistics(purchasedLottos, winningLotto);
    }

    private void showWinningResult() {
        ConsoleView.printBlankLine();
        ConsoleView.printWinningStatistic(winningStatistics);
        showProfitRate();
    }

    private void showProfitRate() {
        int purchasedAmount = purchasedLottos.getLottos().size() * LottoCondition.PRICE.getNumber();
        float profitRate = winningStatistics.calculateProfitRate(purchasedAmount);
        String profitRateWithFormat = String.format("%.1f", profitRate);
        ConsoleView.printProfitRate(profitRateWithFormat);
    }
}
