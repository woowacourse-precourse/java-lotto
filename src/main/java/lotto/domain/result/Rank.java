package lotto.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    THREE_MATCHES(3, 5_000, false),
    FOUR_MATCHES(4, 50_000, false),
    FIVE_MATCHES_WITHOUT_BONUS(5, 1_500_000, false),
    FIVE_MATCHES_WITH_BONUS(5, 30_000_000, true),
    SIX_MATCHES(6, 2_000_000_000, false),
    NONE(0, 0, false);

    private final int hitCount;
    private final int prizeMoney;
    private final boolean hasBonusNumber;

    Rank(int hitCount, int prizeMoney, boolean hasBonusNumber) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static List<Rank> getAllRanksExceptNone() {
        return Arrays.stream(Rank.values())
                .filter(x -> x.hitCount != 0)
                .collect(Collectors.toList());
    }

    public static Rank getRank(int hitCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> findRank(rank, hitCount, hasBonusNumber))
                .findAny()
                .orElse(NONE);
    }

    private static boolean findRank(Rank rank, int hitCnt, boolean hasBonusNumber) {
        return rank.hitCount == hitCnt && rank.hasBonusNumber == hasBonusNumber;
    }

    public Integer getPrize() {
        return this.prizeMoney;
    }

    public Integer getHitCount() {
        return this.hitCount;
    }

    public boolean hasBonusNumber() {
        return this.hasBonusNumber;
    }
}
