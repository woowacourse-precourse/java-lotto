package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private static final int WINNING_MIN_COUNT = 3;
    private static final int BONUS_RANK_COUNT = 5;
    private final int matchedCount;
    private final int prizeMoney;


    private Rank(int matchedCount, int prizeMoney){
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    private static final Map<Integer, Rank> Ranks = new HashMap<>();
    static {
        for (Rank rank : Rank.values()) {
            Ranks.put(rank.matchedCount, rank);
        }
        Ranks.put(THIRD.matchedCount, THIRD);
    }

    public static Rank of(int matchedCount, boolean isBonus) {
        matchedCount = checkNothing(matchedCount);
        if (!Ranks.containsKey(matchedCount)) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d개부터 %d개까지만 일치할 수 있습니다.", NOTHING.matchedCount, FIRST.matchedCount)
            );
        }
        if (isBonus && matchedCount == BONUS_RANK_COUNT) {
            return SECOND;
        }
        return Ranks.get(matchedCount);
    }

    private static int checkNothing(int matchedCount) {
        if (matchedCount >= NOTHING.matchedCount && matchedCount < WINNING_MIN_COUNT) {
            return NOTHING.matchedCount;
        }
        return matchedCount;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}