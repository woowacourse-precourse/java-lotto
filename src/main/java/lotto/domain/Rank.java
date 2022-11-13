package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public enum Rank {
    FIRST(1, "2,000,000,000"),
    SECOND(2, "30,000,000"),
    THIRD(3, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(5, "5,000"),
    NO_LUCK(0, "0");

    private static final Map<Rank, Integer> jackpotCntMap = new EnumMap<>(Map.of(
            FIRST, Lotto.NUMBER_SIZE,
            SECOND, Lotto.NUMBER_SIZE - 1,
            THIRD, Lotto.NUMBER_SIZE - 1,
            FOURTH, Lotto.NUMBER_SIZE - 2,
            FIFTH, Lotto.NUMBER_SIZE - 3,
            NO_LUCK, 0
    ));

    private static final String RANK_MESSAGE_FORMAT = "%d개 일치 (%s원)";
    private static final String SECOND_RANK_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)";

    private final int rank;
    private final String reward;

    Rank(int rank, String reward) {
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
    public String getInfo() {
        if (this.equals(SECOND)) {
            return String.format(SECOND_RANK_MESSAGE_FORMAT, jackpotCntMap.get(SECOND), reward);
        }
        return String.format(RANK_MESSAGE_FORMAT, jackpotCntMap.get(this), reward);
    }
    public int getRankNumber(){
        return rank;
    }
}
