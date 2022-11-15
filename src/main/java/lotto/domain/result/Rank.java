package lotto.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    THREE_MATCHES("%d개 일치 (%,d원) - %d개", 3, 5_000, false),
    FOUR_MATCHES("%d개 일치 (%,d원) - %d개", 4, 50_000, false),
    FIVE_MATCHES_WITHOUT_BONUS("%d개 일치 (%,d원) - %d개", 5, 1_500_000, false),
    FIVE_MATCHES_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", 5, 30_000_000, true),
    SIX_MATCHES("%d개 일치 (%,d원) - %d개", 6, 2_000_000_000, false),
    NONE("none", 0, 0, false);

    private final String message;
    private final int hitCount;
    private final int prizeMoney;
    private final boolean hasBonusNumber;

    Rank(String message, int hitCount, int prizeMoney, boolean hasBonusNumber) {
        this.message = message;
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

    public String getMessage(int count) {
        return String.format(this.message, hitCount, prizeMoney, count);
    }

    public Integer getPrize() {
        return this.prizeMoney;
    }
}
