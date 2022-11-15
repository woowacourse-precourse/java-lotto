package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum LottoRank {
    ZERO(0, 0, false),
    THREE(5_000, 3, false),
    FOUR(50_000, 4, false),
    FIVE(1_500_000, 5, false),
    FIVE_WITH_BONUS(30_000_000, 5, true),
    SIX(2_000_000_000, 6, false);

    private final int prize;
    private final int count;
    private final boolean hasBonusNumber;

    LottoRank(int prize, int count, boolean hasBonusNumber) {
        this.prize = prize;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRank findRank(int count, boolean hasBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.count == count && r.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(ZERO);
    }

    public static Map <LottoRank,Integer> initializeMap() {
        Map <LottoRank,Integer> result = new EnumMap <>(LottoRank.class);
        result.put(LottoRank.ZERO, 0);
        result.put(LottoRank.THREE, 0);
        result.put(LottoRank.FOUR, 0);
        result.put(LottoRank.FIVE, 0);
        result.put(LottoRank.FIVE_WITH_BONUS, 0);
        result.put(LottoRank.SIX, 0);
        return result;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getCount() {
        return this.count;
    }
}
