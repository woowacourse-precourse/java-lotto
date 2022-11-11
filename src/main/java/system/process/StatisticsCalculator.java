package system.process;

import constants.LottoConstant;
import constants.PrizeDivision;
import models.*;

import java.util.Arrays;
import java.util.List;

public class StatisticsCalculator {
    private BoughtLottos boughtLottos;
    private WinningLotto winningLotto;
    private Statistics statistics;

    public StatisticsCalculator(Buying boughtLottos, WinningLottoRegister winningLotto) {
        this.boughtLottos = boughtLottos.getBuyingLottos();
        this.winningLotto = winningLotto.getWinningLotto();
        this.statistics = new Statistics();
    }

    public void calculateStatistics() {
        LottoComparison lottoComparison = new LottoComparison(winningLotto);

        boughtLottos.getLottosData().forEach((purchasedOneLotto) -> {
            lottoComparison.compareLotto(purchasedOneLotto);
            statistics.countDivision(lottoComparison.rank());
        });

        printStatistics();
    }

    private void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        int sum = 0;

        for (int index = PrizeDivision.FIFTH.getDivision(); index >= PrizeDivision.FIRST.getDivision(); index--) {
            String sameCount = prizeDivision.get(index).getMatchingCount();
            String money = prizeDivision.get(index).getPrizeAmount();
            int count = statistics.getDivisionCount().get(index);

            System.out.println(sameCount + " (" + money + ") - " + count + "개");

            if (count > 0) {
                sum += Integer.parseInt(money.replaceAll(",", "")) * count;
            }

        }

        double percent = (double) sum / (boughtLottos.getAmount() * 1000);

        System.out.print("총 수익률은 " + (double) Math.round(percent * 1000) / 10 + "%입니다.");

    }


}
