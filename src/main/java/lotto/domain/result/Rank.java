package lotto.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    THREE_MATCHES("%d개 일치 (%,d원) - %d개", 5_000, 3, false),
    FOUR_MATCHES("%d개 일치 (%,d원) - %d개", 50_000, 4, false),
    FIVE_MATCHES_WITHOUT_BONUS("%d개 일치 (%,d원) - %d개", 1_500_000, 5, false),
    FIVE_MATCHES_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", 30_000_000, 5, true),
    SIX_MATCHES("%d개 일치 (%,d원) - %d개", 2_000_000_000, 6, false),
    NONE("none", 0, 0, false);

    private final String message;
    private final int prizeMoney;
    private final int hitCount;
    private final boolean hasBonusNumber;

    Rank(String message, int prizeMoney, int hitCount, boolean hasBonusNumber) {
        this.prizeMoney = prizeMoney;
        this.hitCount = hitCount;
        this.hasBonusNumber = hasBonusNumber;
        this.message = message;
    }

    public static List<Rank> getAllRanks() {
        return Arrays.stream(Rank.values())
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
