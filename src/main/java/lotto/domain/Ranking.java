package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prize;

    Ranking(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Ranking rank(Lotto lotto, Lotto winningLotto, BonusNumber bonusNumber) {
        int matchCount = winningLotto.countSameNumber(lotto);
        if (matchCount == Ranking.SECOND.getMatchCount()) {
            return Ranking.of(matchCount, checkBonusNumber(lotto, bonusNumber));
        }
        return Ranking.of(matchCount, false);
    }

    private static boolean checkBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return bonusNumber.existIn(lotto);
    }

    public static Ranking of(int matchCount, boolean bonus) {
        if (matchCount == THIRD.matchCount && !bonus) {
            return THIRD;
        }
        if (matchCount < FIFTH.matchCount) {
            return MISS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
