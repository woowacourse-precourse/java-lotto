package system.process;

import constants.PrizeDivision;
import models.PurchasedLottosData;
import models.StatisticsData;
import models.WinningLottoData;

import java.util.Arrays;
import java.util.List;

public class Statistics {

    private PurchasedLottosData purchasedLottosData;
    private WinningLottoData winningLottoData;
    private StatisticsData statisticsData;

    public Statistics(Purchase purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottosData = purchasedLottos.getPurchasedLottosData();
        this.winningLottoData = winningLotto.getWinningLottoData();
        statisticsData = new StatisticsData();
        calculateStatistics();
        printStatistics();
    }

    public void calculateStatistics() {
        LottoComparison lottoComparison = new LottoComparison(winningLottoData);

        purchasedLottosData.getPurchasedLottos().forEach((purchasedOneLotto) -> {
            lottoComparison.setPurchasedOneLotto(purchasedOneLotto);
            statisticsData.countDivision(lottoComparison.startComparison());
        });

    }

    public void printStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");

        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        int sum = 0;

        for(int index=5; index>=1; index--){
            String sameCount = prizeDivision.get(index).getSameCount();
            String money = prizeDivision.get(index).getMoney();
            int count = statisticsData.getDivisionCount().get(index);

            System.out.println(sameCount + " (" + money +") - " + count + "개");

            if(count > 0){
                sum += Integer.parseInt(money.replaceAll("," ,""))*count;
            }

        }

        double percent = (double)sum/(purchasedLottosData.getAmount()*1000);

        System.out.println("총 수익률은 "+(double)Math.round(percent*1000)/10 +"%입니다.");

    }


}
