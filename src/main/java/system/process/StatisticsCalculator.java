package system.process;

import constants.PrizeDivision;
import models.BoughtLottos;
import models.Statistics;
import models.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class StatisticsCalculator {
    private BoughtLottos boughtLottos;
    private WinningLotto winningLotto;
    private Statistics statistics;

    public StatisticsCalculator(Buying boughtLottos, WinningLottoRegister winningLotto) {
        this.boughtLottos = boughtLottos.getBoughtLottos();
        this.winningLotto = winningLotto.getWinningLotto();
        this.statistics = new Statistics();
        calculateStatistics();
        printStatistics();
    }

    private void calculateStatistics() {
        LottoComparison lottoComparison = new LottoComparison(winningLotto);

        boughtLottos.getLottos().forEach((Lotto) -> {
            lottoComparison.startComparison(Lotto);
            statistics.countDivisions(lottoComparison.rank());
        });
    }

    private void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        long prizeAmountSummation = printPrizeDivisionsAndAccumulatePrizeAmount(prizeDivision);
        calculatePercentAndPrintPercent(prizeAmountSummation);
    }

    private long printPrizeDivisionsAndAccumulatePrizeAmount(List<PrizeDivision> prizeDivision) {
        long prizeAmountSummation = 0;

        for (int index = PrizeDivision.FIFTH.getDivision(); index >= PrizeDivision.FIRST.getDivision(); index--) {
            String matchingCount = prizeDivision.get(index).getMatchingCount();
            String prizeAmount = prizeDivision.get(index).getPrizeAmount();
            int divisionCount = statistics.getDivisionsCount().get(index);
            
            prizeAmountSummation += Integer.parseInt(prizeAmount.replaceAll(",", "")) * divisionCount;
            /*중복 코드를 방지하기 위해 누적하면서 출력.*/
            System.out.println(matchingCount + " (" + prizeAmount + "원) - " + divisionCount + "개");
        }
        
        return prizeAmountSummation;
    }

    private void calculatePercentAndPrintPercent(long prizeAmountSummation) {
        double rate = (double) prizeAmountSummation / (boughtLottos.getAmount() * 1000);
        double percent = (double) Math.round(rate * 1000) / 10;
        System.out.print("총 수익률은 " + percent + "%입니다.");
    }
}
