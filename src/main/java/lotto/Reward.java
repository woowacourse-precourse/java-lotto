package lotto;

import java.util.Arrays;

public enum Reward {
    NOTHING(Rank.NOTHING, 0),
    FIFTH(Rank.FIFTH,5_000L),
    FOURTH(Rank.FOURTH, 50_000L),
    THIRD(Rank.THIRD, 1_500_000L),
    SECOND(Rank.SECOND, 30_000_000L),
    FIRST(Rank.FIRST, 2_000_000_000L);

    private Rank rank;
    private long reward;

    Reward(Rank rank, long reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public long reward() {
        return reward;
    }

    public Rank rank() {
        return rank;
    }

    public static Reward valueOfRank(Rank rank) {
        return Arrays.stream(values())
                .filter(value -> value.rank.name().equals(rank.name()))
                .findAny()
                .orElse(Reward.NOTHING);
    }
}
