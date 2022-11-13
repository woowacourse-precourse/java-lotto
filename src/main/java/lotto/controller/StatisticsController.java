package lotto.controller;

import lotto.model.EarningRate;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;

import java.util.List;

public class StatisticsController extends Controller{
    public Statistics createStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Statistics statistics = new Statistics(lottos, winningLotto);
        outputView.print(statistics.toString());
        return statistics;
    }
}
