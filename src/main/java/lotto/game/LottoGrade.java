package lotto.game;

public enum LottoGrade {
    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L),
    NOTHING(0);


    private final long prize;

    LottoGrade(long prize) {
        this.prize = prize;
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