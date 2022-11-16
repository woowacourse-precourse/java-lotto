package lotto.domain.winning;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int count;
    private final int prize;
    private final boolean hasBonus;

    WinningRank(int count, int prize, boolean hasBonus) {
        this.count = count;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static WinningRank of(int count, boolean hasBonus) {
        if (checkSecondRank(count, hasBonus)) {
            return SECOND;
        }

        return matchRank(count);
    }

    private static boolean checkSecondRank(int count, boolean hasBonus) {
        return (count == SECOND.count && hasBonus);
    }

    private static WinningRank matchRank(int count) {
        return Arrays.stream(values())
                .filter(Predicate.not(rank -> rank.isSecond()))
                .filter(rank -> checkSameCount(rank, count))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean checkSameCount(WinningRank rank, int count) {
        return rank.count == count;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public int getPrize() {
        return this.prize;
    }
}
