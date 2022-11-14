package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import java.io.IOException;
import java.util.List;

import static lotto.service.Calculator.*;
import static lotto.console.Output.*;
import static lotto.console.Output.BufferedRecorder.*;


public class StatisticController {

    private static final int[] countStatistic = {-1,-1,-1,0,0,0,0,0};


    private void updateStatisticCount(List<Lotto> lottoList, List<Integer> winningLotto) throws IOException {
        writeStatistics();

        lottoList.stream()
                .map(Lotto::getNumbers)
                .map(x -> intersection(x, winningLotto))
                .map(x -> scalingStatisticIndex(x.size(), x.contains(winningLotto.get(6))))
                .forEach(x -> countStatistic[x] += 1);
    }

    private void recordGrade() throws IOException {
        for(int i = 3; i < 8; i++) {
            writeGrading(i, countStatistic[i]);
        }
    }

    private void recordRevenueRate() throws IOException {
        int totalRevenue = 0;

        for(int i = 3; i < 8; i++) {
            totalRevenue += countStatistic[i] * Statistic.getRevenue(i);
        }

        writeRevenueRate(calculateRevenueRate(totalRevenue, getCost()));
    }

    public void runStatisticController(List<Lotto> lottoList, List<Integer> winningLotto) throws IOException {
        updateStatisticCount(lottoList, winningLotto);
        recordGrade();
        recordRevenueRate();
        printBufferedStream();
    }
}