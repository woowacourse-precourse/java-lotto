package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;
import view.EarningRateView;
import view.PrizeStatisticsView;

public class PrizeController {

    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;
    private final int countLotto;

    public PrizeController(List<Lotto> lottos, WinningNumber winningNumber, int countLotto) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.countLotto = countLotto;
    }

    public void run() {
        List<Integer> prizeStatistics = calculatePrize(lottos, winningNumber);
        viewPrizeStatistics(prizeStatistics);
        double earningRate = calculateEarningRate(prizeStatistics, countLotto);
        viewEarningRate(earningRate);
    }

    private List<Integer> calculatePrize(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Integer> prizeStatistics = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            int count = winningNumber.countMatch(lotto);
            boolean isBonus = winningNumber.isBonus(lotto);
            setPrizeStatistics(prizeStatistics, count, isBonus);
        }
        return prizeStatistics;
    }

    private void setPrizeStatistics(List<Integer> prizeStatistics, int count, boolean isBonus) {
        if (count == Prize.FIRST_PLACE.getMatch()) {
            prizeStatistics.set(0, prizeStatistics.get(0) + 1);
        } else if (count == Prize.SECOND_PLACE.getMatch() && isBonus == Prize.SECOND_PLACE.isBonus()) {
            prizeStatistics.set(1, prizeStatistics.get(1) + 1);
        } else if (count == Prize.THIRD_PLACE.getMatch()) {
            prizeStatistics.set(2, prizeStatistics.get(2) + 1);
        } else if (count == Prize.FOURTH_PLACE.getMatch()) {
            prizeStatistics.set(3, prizeStatistics.get(3) + 1);
        } else if (count == Prize.FIFTH_PLACE.getMatch()) {
            prizeStatistics.set(4, prizeStatistics.get(4) + 1);
        }
    }

    private void viewPrizeStatistics(List<Integer> prizeStatistics) {
        PrizeStatisticsView prizeStatisticsView = new PrizeStatisticsView(prizeStatistics);
        prizeStatisticsView.show();
    }

    private double calculateEarningRate(List<Integer> prizeStatistics, int countLotto) {
        double prizeSum = 0;
        int index = 0;
        for (Prize prize : Prize.values()) {
            prizeSum += prize.getMoney() * prizeStatistics.get(index);
            index++;
        }
        double earningRate = prizeSum / (countLotto * 1000) * 100;
        earningRate = Math.round(earningRate * 10) / 10.0;
        return earningRate;
    }

    private void viewEarningRate(double earningRate) {
        EarningRateView earningRateView = new EarningRateView(earningRate);
        earningRateView.show();
    }
}
