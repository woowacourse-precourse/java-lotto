package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.LottoGenerateView;
import lotto.view.PurchaseView;
import lotto.view.StatisticsView;
import lotto.view.WinningNumbersGenerateView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final PurchaseView purchaseView = new PurchaseView();
    private final LottoGenerateView lottoGenerateView = new LottoGenerateView();
    private final WinningNumbersGenerateView winningNumbersGenerateView = new WinningNumbersGenerateView();
    private final StatisticsView statisticsView = new StatisticsView();

    public Money purchase() {
        purchaseView.requestPurchaseAmount();
        return lottoService.purchase(purchaseView.getPurchaseAmount());
    }

    public List<Lotto> generateLottos(Money money) {
        List<Lotto> lottos = lottoService.generateLottos(money);
        lottoGenerateView.printGeneratedLottos(lottos);
        return lottos;
    }

    public WinningNumbers generateWinningNumbers() {
        winningNumbersGenerateView.requestWinningNumbers();
        String numbers = winningNumbersGenerateView.getInput();

        winningNumbersGenerateView.requestBonusNumber();
        String bonus = winningNumbersGenerateView.getInput();

        return lottoService.generateWinningNumbers(numbers, bonus);
    }

    public void showStatistics(WinningNumbers winningNumbers, List<Lotto> lottos) {
        Statistics statistics = lottoService.generateStatistics(winningNumbers, lottos);
        statisticsView.printStatistics(statistics);
    }
}
