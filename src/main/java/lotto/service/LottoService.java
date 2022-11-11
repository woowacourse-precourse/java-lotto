package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.User;
import lotto.domain.Winner;
import lotto.util.LottoGenerator;
import lotto.view.ViewController;

import java.util.List;
import java.util.Map;

public class LottoService {
    private final ViewController viewController;
    private final LottoGenerator lottoGenerator;
    private User user;

    public LottoService() {
        this.viewController = new ViewController();
        this.lottoGenerator = new LottoGenerator();
    }

    public void start() {
        purchase();
        getPrizeLottoAndBonusNumber();
        getStatisticsResult();
        calculateProfit();
    }

    private void purchase() {
        long amount = viewController.inputPurchaseAmount();
        List<Lotto> lotto = lottoGenerator.purchase(amount);
        viewController.printPurchasedLotto(lotto);
        this.user = new User(lotto);
    }

    private void getPrizeLottoAndBonusNumber() {
        List<Integer> prizeLotto = viewController.inputPrizeLotto();
        int bonusNumber = viewController.inputBonusNumber();

        Lotto lotto = new Lotto(prizeLotto);
        Statistics statistics = new Statistics(lotto, bonusNumber);
        user.setStatistics(statistics);
    }

    private void getStatisticsResult() {
        Map<Winner, Integer> result = user.getResult();
        viewController.printStatisticsByRank(result);
    }

    private void calculateProfit() {
        float profit = user.calculateProfit();
        viewController.printProfitPercentage(profit);
    }

}
