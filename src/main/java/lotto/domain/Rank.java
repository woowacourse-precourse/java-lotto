package lotto.domain;

import java.util.Arrays;

public enum Rank {

    //상수 선언 순서는 prize 기준 오름차순 이어야 합니다
    ZERO_MATCH(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);


    private final int prize;
    private final int matched;
    private final boolean bonus;

    Rank(int prize, int matched, boolean bonus) {
        this.prize = prize;
        this.matched = matched;
        this.bonus = bonus;
    }

    public static Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchedCount = winningNumbers.countWinningLottoNumbersMatchedIn(lotto);
        boolean isBonus = winningNumbers.isBonusMatchedIn(lotto);

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matched == matchedCount)
                .filter(rank -> rank.bonus == isBonus)
                .findAny()
                .orElse(ZERO_MATCH);
    }

    public static int getRankPrize(Rank rank) {
        return rank.prize;
    }

    public static int getMatchedCountFor(Rank rank) {
        return rank.matched;
    }

}

