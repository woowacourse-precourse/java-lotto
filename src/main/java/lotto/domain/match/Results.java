package lotto.domain.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private final Map<MatchAndReward, Integer> counts;

    public Results(List<MatchAndReward> matchAndRewardList) {
        this.counts = createCounts(matchAndRewardList);
    }

    private Map<MatchAndReward, Integer> createCounts(List<MatchAndReward> matchAndRewardList) {
        Map<MatchAndReward, Integer> counts = new HashMap<>();

        for (MatchAndReward matchAndReward : matchAndRewardList) {
            int currentCount = counts.getOrDefault(matchAndReward, 0);
            counts.put(matchAndReward, currentCount + 1);
        }

        return counts;
    }

    public float getYield(int buyMoney) {
        int totalReward = 0;

        for (MatchAndReward matchAndReward : MatchAndReward.values()) {
            int count = counts.get(matchAndReward);
            totalReward += matchAndReward.getReward() * count;
        }

        return (float) totalReward / buyMoney;
    }

    public int getCount(MatchAndReward matchAndReward) {
        return counts.get(matchAndReward);
    }
}
