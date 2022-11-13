package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = new HashMap<>();
    }

    public void addResult(Rank rank) {
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }

    public Money reward() {
        Money reward = new Money(0);
        for (Entry<Rank, Integer> entry : rewardCalculateEntrySet()) {
            Money rankReward = entry.getKey().reward();
            reward = reward.add(rankReward.multiply(entry.getValue()));
        }
        return reward;
    }

    private List<Entry<Rank, Integer>> rewardCalculateEntrySet() {
        return lottoResult.entrySet().stream()
                .filter(rankIntegerEntry -> rankIntegerEntry.getKey().reward().notZero())
                .collect(Collectors.toList());
    }

    public int rankCount(Rank rank) {
        return lottoResult.getOrDefault(rank, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }
}
