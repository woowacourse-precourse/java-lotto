package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FORTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private static final int MATCHED_NUMBER_TO_CHECK_BONUS_NUMBER = 5;

    private final int matched;
    private final int prize;
    private final boolean bonus;

    Rank(int matched, int prize, boolean bonus) {
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

    public int getMatched() {
        return matched;
    }

    public int getPrize() {
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
