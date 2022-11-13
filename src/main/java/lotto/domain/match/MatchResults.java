package lotto.domain.match;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MatchResults {

    private final Map<Reward, Integer> counts;

    public MatchResults(List<Reward> rewardList) {
        this.counts = createCounts(rewardList);
    }

    private Map<Reward, Integer> createCounts(List<Reward> rewardList) {
        Map<Reward, Integer> counts = new EnumMap<>(Reward.class);

        for (Reward reward : rewardList) {
            if (reward == null) {
                continue;
            }

            int currentCount = counts.getOrDefault(reward, 0);
            counts.put(reward, currentCount + 1);
        }

        return counts;
    }

    public long getTotalPrice() {
        return counts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public int getCount(Reward reward) {
        return counts.getOrDefault(reward, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MatchResults)) {
            return false;
        }

        MatchResults results = (MatchResults) o;

        return Objects.equals(counts, results.counts);
    }

    @Override
    public int hashCode() {
        return counts != null ? counts.hashCode() : 0;
    }
}
