package lotto;

import java.util.Arrays;

public enum LottoOperator {
    NO_LUCK(0, false, 0),
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int count;
    private final boolean bonus;
    private final int winningAmount;

    LottoOperator(int count, boolean bonus, int winningAmount) {
        this.count = count;
        this.bonus = bonus;
        this.winningAmount = winningAmount;
    }

    public static LottoOperator find(int count, boolean bonus) {
        if (checkBonus(count, bonus)) {
            return FIVE_BONUS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount(count))
                .findFirst()
                .orElse(NO_LUCK);
    }

    private static boolean checkBonus(int count, boolean bonus) {
        return count == 5 && bonus;
    }

    private boolean matchCount(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
