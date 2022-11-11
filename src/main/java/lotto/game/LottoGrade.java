package lotto.game;

public enum LottoGrade {
    FIRST(Money.of(2_000_000_000L)),
    SECOND(Money.of(30_000_000L)),
    THIRD(Money.of(1_500_000L)),
    FOURTH(Money.of(50_000L)),
    FIFTH(Money.of(5_000L)),
    NOTHING(Money.NO_MONEY);

    private final Money prize;

    LottoGrade(Money money) {
        this.prize = money;
    }

    public long getPrize() {
        return prize.getValue();
    }

    public static LottoGrade confirmWinning(int winningCount, boolean bonusMatch) {
        if (winningCount == 6) {
            return FIRST;
        }
        if (bonusMatch) {
            winningCount++;
        }
        if (winningCount == 6) {
            return SECOND;
        }
        if (winningCount == 5) {
            return THIRD;
        }
        if (winningCount == 4) {
            return FOURTH;
        }
        if (winningCount == 3) {
            return FIFTH;
        }
        return NOTHING;
    }
}