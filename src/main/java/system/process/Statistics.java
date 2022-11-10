package system.process;

import models.PurchasedLottosData;
import models.StatisticsData;
import models.WinningLottoData;

public class Statistics {

    private PurchasedLottosData purchasedLottosData;
    private WinningLottoData winningLottoData;
    private StatisticsData statisticsData;

    public Statistics(Purchase purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottosData = purchasedLottos.getPurchasedLottosData();
        this.winningLottoData = winningLotto.getWinningLottoData();
        statisticsData = new StatisticsData();

    }

    public void calculateStatistics() {
        LottoComparison lottoComparison = new LottoComparison(winningLottoData);

        purchasedLottosData.getPurchasedLottos().forEach((purchasedOneLotto) -> {
            lottoComparison.setPurchasedOneLotto(purchasedOneLotto);
            statisticsData.countDivision(lottoComparison.startComparison());
        });

    }

    public void printStatistics(){

    }


}
