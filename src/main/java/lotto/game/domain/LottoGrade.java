package lotto.game.domain;

import java.util.Arrays;

public enum LottoGrade {
    FIRST(Money.of(2_000_000_000L), 6, false),
    SECOND(Money.of(30_000_000L), 5, true),
    THIRD(Money.of(1_500_000L), 5, false),
    FOURTH(Money.of(50_000L), 4, false),
    FIFTH(Money.of(5_000L), 3, false),
    NOTHING(Money.ZERO, 0, false);

    private final Money prize;
    private final int matchCount;
    private final boolean isBonus;

    LottoGrade(Money money, int matchCount, boolean isBonus) {
        this.prize = money;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public Money getPrize() {
        return prize;
    }

    public static LottoGrade confirmWinning(int winningCount, boolean bonusMatch) {
        if (bonusMatch && winningCount == 5) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(grade -> !grade.isBonus)
                .filter(grade -> grade.matchCount == winningCount)
                .findAny()
                .orElse(NOTHING);
    }
}