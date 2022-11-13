package lotto.client;

import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.StatisticsController;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;

import java.util.List;

public class Client {
    private PurchaseController purchaseController = new PurchaseController();
    private LottoController lottoController = new LottoController();
    private StatisticsController statisticsController = new StatisticsController();

    public void run() {
        try {
            int money = purchaseController.inputMoneyByUser();
            int numberOfLotto = purchaseController.purchaseLotto(money);

            List<Lotto> lottos = lottoController.createLottos(numberOfLotto);

            WinningLotto winningLotto = lottoController.createWinningLotto();

            Statistics statistics = statisticsController.createStatistics(lottos, winningLotto);
            statisticsController.printEarningRate(money,statistics);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
