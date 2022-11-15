package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import java.util.List;

import static lotto.service.Calculator.*;
import static lotto.console.Output.*;


public class StatisticController {

    private static final int[] countStatistic = {-1,-1,-1,0,0,0,0,0};


    private void updateStatisticCount(
            List<Lotto> lottoList,
            List<Integer> winningLotto
    ) {
        System.out.println();
        printStatistics();

        lottoList.stream()
                .map(Lotto::getNumbers)
                .map(x -> intersection(x, winningLotto))
                .map(x -> scalingStatisticIndex(x.size(), x.contains(winningLotto.get(6))))
                .forEach(x -> countStatistic[x] += 1);
    }

    private void recordGrade() {
        for(int i = 3; i < 8; i++) {
            printGrading(i, countStatistic[i]);
        }
    }

    private void recordRevenueRate() {
        int totalRevenue = 0;

        for(int i = 3; i < 8; i++) {
            totalRevenue += countStatistic[i] * Statistic.getRevenue(i);
        }

        printRevenueRate(calculateRevenueRate(totalRevenue, getCost()));
    }

    public void runStatisticController(
            List<Lotto> lottoList,
            List<Integer> winningLotto
    ) {
        updateStatisticCount(lottoList, winningLotto);
        recordGrade();
        recordRevenueRate();
    }
}