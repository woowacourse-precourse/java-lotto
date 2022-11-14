package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCondition;
import lotto.domain.Payment;
import lotto.domain.PurchasedLottos;
import lotto.domain.RandomNumbers;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private PurchasedLottos purchasedLottos;
    private WinningLotto winningLotto;
    private WinningStatistics winningStatistics;

    public void process() {
        try {
            purchaseLottos();
            showPurchasedLottos();
            setWinningLotto();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        createWinningStatistics();
        showWinningResult();
    }

    private void purchaseLottos() {
        int inputPrice = ConsoleView.inputPurchasePrice();
        Payment payment = new Payment(inputPrice);
        List<Lotto> randomLottos = createRandomLottos(payment.getAvailableLottoAmount());
        purchasedLottos = new PurchasedLottos(randomLottos);
    }

    private List<Lotto> createRandomLottos(int lottoAmount) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = createRandomLotto();
            randomLottos.add(lotto);
        }
        return randomLottos;
    }

    private Lotto createRandomLotto() {
        RandomNumbers randomNumbers = new RandomNumbers(
                LottoCondition.MIN_NUMBER.getNumber(),
                LottoCondition.MAX_NUMBER.getNumber(),
                LottoCondition.COUNT.getNumber()
        );
        return new Lotto(randomNumbers.getRandomNumbers());
    }

    private void showPurchasedLottos() {
        int amount = purchasedLottos.getPurchasedLottos().size();
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
        winningStatistics = new WinningStatistics(purchasedLottos, winningLotto);
    }

    private void showWinningResult() {
        ConsoleView.printBlankLine();
        ConsoleView.printWinningStatistic(winningStatistics);
        showProfitRate();
    }

    private void showProfitRate() {
        int purchasedAmount = purchasedLottos.getPurchasedLottos().size() * LottoCondition.PRICE.getNumber();
        float profitRate = winningStatistics.calculateProfitRate(purchasedAmount);
        String profitRateWithFormat = String.format("%.1f", profitRate);
        ConsoleView.printProfitRate(profitRateWithFormat);
    }
}
