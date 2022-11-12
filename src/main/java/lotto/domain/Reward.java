package lotto.domain;

import lotto.domain.chart.RankChart;
import lotto.domain.chart.RewardChart;

import java.util.ArrayList;
import java.util.List;

public class Reward {

    public static List<Integer> rewardMoneys(List<Integer> ranking) {
        List<Integer> moneyRecord = new ArrayList<>();
        for (int rankNumber : ranking) {
            moneyRecord.add(giveMoney(rankNumber));

        }
        return moneyRecord;
    }

    private static int giveMoney(int i) {
        if (i == RankChart.FirstPlace.getValue()) {
            return RewardChart.First.getValue();

        }
        if (i == RankChart.SecondPlace.getValue()) {
            return RewardChart.Second.getValue();

        }
        if (i == RankChart.ThirdPlace.getValue()) {
            return RewardChart.Third.getValue();

        }
        if (i == RankChart.FourthPlace.getValue()) {
            return RewardChart.Fourth.getValue();

        }
        if (i == RankChart.FifthPlace.getValue()) {
            return RewardChart.Fifth.getValue();
        }
        return 0;
    }
}
