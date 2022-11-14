package system.process;

import constants.LottoConstant;
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


    public StatisticsCalculator(Buying buying, WinningLottoRegister winningLottoRegister) {
        this.statistics = new Statistics();
        this.boughtLottos = buying.getBoughtLottos();
        this.winningLotto = winningLottoRegister.getWinningLotto();
        startCalculator();
    }

    private void startCalculator() {
        calculateStatistics();
        long prizeAmountSummation = accumulatePrizeAmount();
        double rateOfReturn = calculateRateOfReturn(prizeAmountSummation);
        statistics.setPrizeAmountSummationAndRateOfReturn(prizeAmountSummation, rateOfReturn);
    }

    private void calculateStatistics() {
        LottoComparison lottoComparison = new LottoComparison(winningLotto);

        boughtLottos.getLottos().forEach((Lotto) -> {
            lottoComparison.startComparison(Lotto);
            countDivisions(lottoComparison.rank());
        });
    }

    private void countDivisions(int division) {
        if (division != PrizeDivision.NO_DIVISION.ordinal()) {
            statistics.getDivisionsCount().set(division, statistics.getDivisionsCount().get(division) + 1);
        }
    }

    private long accumulatePrizeAmount() {
        long prizeAmountSummation = 0;
        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        for (int index = PrizeDivision.FIFTH.ordinal(); index >= PrizeDivision.FIRST.ordinal(); index--) {
            int prizeAmount = prizeDivision.get(index).getPrizeAmount();
            int divisionCount = statistics.getDivisionsCount().get(index);

            prizeAmountSummation += prizeAmount * divisionCount;
        }
        return prizeAmountSummation;
    }

    private double calculateRateOfReturn(long prizeAmountSummation) {
        double rate = (double) prizeAmountSummation / (boughtLottos.getAmount() * LottoConstant.LOTTO_PRICE);
        return (double) Math.round(rate * 1000) / 10;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
