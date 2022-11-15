package lotto.domain;

import lotto.service.RankChart;
import lotto.service.RewardChart;

import java.util.ArrayList;
import java.util.List;

public class Reward {

    public List<Integer> rewardMoneys(List<Integer> ranking) {
        List<Integer> moneyRecord = new ArrayList<>();
        for (int rankNumber : ranking) {
            moneyRecord.add(giveMoney(rankNumber));

        }
        return moneyRecord;
    }

    private int giveMoney(int i) {
        if (i == RankChart.FIRST_PLACE.getValue()) {
            return RewardChart.FIRST_REWARD.getValue();
        }
        if (i == RankChart.SECOND_PLACE.getValue()) {
            return RewardChart.SECOND_REWARD.getValue();
        }
        if (i == RankChart.THIRD_PLACE.getValue()) {
            return RewardChart.THIRD_REWARD.getValue();
        }
        if (i == RankChart.FOURTH_PLACE.getValue()) {
            return RewardChart.FOURTH_REWARD.getValue();
        }
        if (i == RankChart.FIFTH_PLACE.getValue()) {
            return RewardChart.FIFTH_REWARD.getValue();
        }
        return 0;
    }
}
