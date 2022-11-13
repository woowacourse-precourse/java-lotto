package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int RANK_COUNT_DEFAULT_VALUE = 0;
    private static final int DEFAULT_REWARD = 0;

    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = new HashMap<>();
    }

    public void addResult(Rank rank) {
        lottoResult.put(rank, lottoResult.getOrDefault(rank, RANK_COUNT_DEFAULT_VALUE) + 1);
    }

    public Money reward() {
        Money reward = new Money(DEFAULT_REWARD);
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
        return lottoResult.getOrDefault(rank, RANK_COUNT_DEFAULT_VALUE);
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
