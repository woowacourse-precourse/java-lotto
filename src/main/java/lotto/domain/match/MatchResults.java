package lotto.domain.match;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MatchResults {

    private final Map<Reward, Integer> counts;

    public MatchResults(List<Reward> rewardList) {
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

    public int getTotalPrice() {
        return counts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public int getCount(Reward reward) {
        return counts.getOrDefault(reward, 0);
    }
}
