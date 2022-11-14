package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FORTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    MISS(0, 0L, false);

    private static final int MATCHED_NUMBER_TO_CHECK_BONUS_NUMBER = 5;

    private final int matched;
    private final long prize;
    private final boolean bonus;

    Rank(int matched, long prize, boolean bonus) {
        this.matched = matched;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static Rank getRank(Lotto lotto, WinningLotto winningLotto) {
        int matchedCount = getMatchedCount(lotto, winningLotto);
        boolean bonusMatched = isBonusMatched(matchedCount, lotto, winningLotto.getBonusNumber());

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matched == matchedCount)
                .filter(rank -> rank.bonus == bonusMatched)
                .findFirst()
                .orElse(MISS);
    }

    public static List<Rank> getRanksExceptMiss() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparing(Rank::getPrize))
                .collect(Collectors.toList());
    }

    public int getMatched() {
        return matched;
    }

    public String getPrizeWithDecimalFormat() {
        return new DecimalFormat("###,###").format(prize);
    }

    public long getPrize() {
        return prize;
    }

    private static int getMatchedCount(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getLotto().getNumbers()::contains)
                .count();
    }

    private static boolean isBonusMatched(int matchedCount, Lotto lotto, int bonusNumber) {
        if (matchedCount != MATCHED_NUMBER_TO_CHECK_BONUS_NUMBER) {
            return false;
        }

        return lotto.getNumbers().contains(bonusNumber);
    }
}
