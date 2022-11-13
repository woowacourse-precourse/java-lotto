package lotto;

import constants.LottoConstants;

import java.util.Arrays;

public enum Wins {
    OTHER(0, 0, false),
    THREE_MATCHED(5000, 3, false),
    FOUR_MATCHED(50_000, 4, false),
    FIVE_MATCHED(1_500_000, 5, false),
    FIVE_WITH_BONUS_MATCHED(30_000_000, 5, true),
    SIX_MATCHED(2_000_000_000, 6, false);

    private final int winnings;
    private final int count;
    private final boolean bonus;

    Wins(int winnings, int count, boolean bonus) {
        this.winnings = winnings;
        this.count = count;
        this.bonus = bonus;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static double getProfitRate(int purchaseAmount) {
        int profit = Arrays.stream(Wins.values())
                .map(win -> win.winnings * win.count)
                .mapToInt(Integer::valueOf)
                .sum();

        return ((double) profit / purchaseAmount) * LottoConstants.PERCENTAGE_UNIT;
    }

    public static Wins getWins(int matchingCount, boolean bonus) {
        return Arrays.stream(Wins.values())
                .filter(win -> win.getCount() == matchingCount && win.isBonus() == bonus)
                .findAny()
                .orElse(OTHER);
    }
}
