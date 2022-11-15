package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public enum Rank {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5000),
    NO_LUCK(0, 0);

    private static final Map<Rank, Integer> jackpotCriteria = new EnumMap<>(Map.of(
            FIRST, Lotto.NUMBER_SIZE,
            SECOND, Lotto.NUMBER_SIZE - 1,
            THIRD, Lotto.NUMBER_SIZE - 1,
            FOURTH, Lotto.NUMBER_SIZE - 2,
            FIFTH, Lotto.NUMBER_SIZE - 3,
            NO_LUCK, 0
    ));
    private final int rankNumber;
    private final int reward;

    Rank(int rankNumber, int reward) {
        this.rankNumber = rankNumber;
        this.reward = reward;
    }

    public static Rank getInstanceOf(int jackpotHitCnt, boolean hitBonus) {
        if (jackpotCriteria.get(THIRD) == jackpotHitCnt && !hitBonus) {
            return THIRD;
        }

        for (Rank rank : Rank.values()) {
            if (jackpotCriteria.get(rank) == jackpotHitCnt) {
                return rank;
            }
        }
        return NO_LUCK;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public int getReward() {
        return reward;
    }

    public int getJackpotCriteriaCnt() {
        return jackpotCriteria.get(this);
    }
}
