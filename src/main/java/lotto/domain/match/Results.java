package lotto.domain.match;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Results {

    private final Map<Reward, Integer> counts;

    public Results(List<Reward> rewardList) {
        this.counts = createCounts(rewardList);
    }

    private Map<Reward, Integer> createCounts(List<Reward> rewardList) {
        Map<Reward, Integer> counts = new EnumMap<>(Reward.class);

        for (Reward reward : rewardList) {
            int currentCount = counts.getOrDefault(reward, 0);
            counts.put(reward, currentCount + 1);
        }

        return counts;
    }

    public float getYield(int buyMoney) {
        int totalReward = 0;

        for (Reward reward : Reward.values()) {
            int count = counts.getOrDefault(reward, 0);
            totalReward += reward.getReward() * count;
        }

        return (float) totalReward / buyMoney;
    }

    public int getCount(Reward reward) {
        return counts.getOrDefault(reward, 0);
    }
}
