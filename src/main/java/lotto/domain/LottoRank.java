package lotto.domain;

import lotto.utils.Formatter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    MISS(0, false, 0);

    private final int count;
    private final boolean isSameBonus;
    private final int amount;

    LottoRank(int count, boolean isSameBonus, int amount) {
        this.count = count;
        this.isSameBonus = isSameBonus;
        this.amount = amount;
    }

    public static LottoRank calculate(int count, boolean isSameBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.count == count && rank.isSameBonus == isSameBonus) {
                return rank;
            }
        }

        return MISS;
    }

    public static List<LottoRank> getLottoRank() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotMiss)
                .collect(Collectors.toList());
    }

    private static boolean isNotMiss(LottoRank lottoRank) {
        return lottoRank != MISS;
    }

    public int getCount() {
        return count;
    }

    public boolean isSameBonus() {
        return isSameBonus;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("개 일치");

        if (isSameBonus()) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (").append(Formatter.format(amount)).append(")");
        return sb.toString();
    }
}
