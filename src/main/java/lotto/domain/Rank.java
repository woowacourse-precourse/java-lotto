package lotto.domain;

import java.util.EnumMap;

public enum Rank {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5000),
    NO_LUCK(0, 0);

    private static final EnumMap<Rank, Integer> jackpotCntMap = new EnumMap<>(Rank.class);
    static {
        jackpotCntMap.put(FIRST, Lotto.NUMBER_SIZE);
        jackpotCntMap.put(SECOND, Lotto.NUMBER_SIZE - 1);
        jackpotCntMap.put(THIRD, Lotto.NUMBER_SIZE - 1);
        jackpotCntMap.put(FOURTH, Lotto.NUMBER_SIZE - 2);
        jackpotCntMap.put(FIFTH, Lotto.NUMBER_SIZE - 3);
        jackpotCntMap.put(NO_LUCK, 0);
    }
    private final int rank;
    private final int reward;

    Rank(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public static Rank of(int jackpotCnt, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (jackpotCntMap.get(THIRD) == jackpotCnt && !hasBonus) {
                return THIRD;
            }
            if (jackpotCntMap.get(rank) == jackpotCnt) {
                return rank;
            }
        }
        return NO_LUCK;
    }
}
