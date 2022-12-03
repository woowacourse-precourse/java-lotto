package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum Winning {
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int correctCount;
    private final boolean bonus;
    private final long winningPrice;

    Winning(int correctCount, boolean bonus, long winningPrice) {
        this.correctCount = correctCount;
        this.bonus = bonus;
        this.winningPrice = winningPrice;
    }

    public long getWinningPrice() {
        return winningPrice;
    }

    public static Optional<Winning> findByCountAndBonus(int correctCount, boolean bonus) {
        return Arrays.stream(Winning.values())
                .filter(w -> w.correctCount == correctCount && w.bonus == bonus)
                .findFirst();
    }
}
