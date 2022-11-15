package lotto.domain;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public enum Rank {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5000),
    NO_LUCK(0, 0);

    private static final Map<Rank, Integer> jackpotCntMap = new EnumMap<>(Map.of(
            FIRST, Lotto.NUMBER_SIZE,
            SECOND, Lotto.NUMBER_SIZE - 1,
            THIRD, Lotto.NUMBER_SIZE - 1,
            FOURTH, Lotto.NUMBER_SIZE - 2,
            FIFTH, Lotto.NUMBER_SIZE - 3,
            NO_LUCK, 0
    ));

    private static final String RANK_INFO_MESSAGE_FORMAT = "%d개 일치 (%s원)";
    private static final String SECOND_RANK_INFO_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)";
    private static final DecimalFormat rewardFormat = new DecimalFormat("###,###");

    private final int rank;
    private final int reward;

    Rank(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public static Rank getInstanceOf(int jackpotCnt, boolean hasBonus) {
        if (jackpotCntMap.get(THIRD) == jackpotCnt && !hasBonus) {
            return THIRD;
        }

        for (Rank rank : Rank.values()) {
            if (jackpotCntMap.get(rank) == jackpotCnt) {
                return rank;
            }
        }
        return NO_LUCK;
    }

    public String getInfo() {
        String reward = rewardFormat.format(this.reward);
        String infoFormat = RANK_INFO_MESSAGE_FORMAT;
        if (this.equals(SECOND)) {
            infoFormat = SECOND_RANK_INFO_MESSAGE_FORMAT;
        }

        return String.format(infoFormat, jackpotCntMap.get(this), reward);
    }

    public int getRankNumber() {
        return rank;
    }

    public int getReward() {
        return reward;
    }

    public int getJackpotHitCnt() {
        return jackpotCntMap.get(rank);
    }
}
