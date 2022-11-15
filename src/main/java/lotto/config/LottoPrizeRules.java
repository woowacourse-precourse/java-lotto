package lotto.config;

public enum LottoPrizeRules {

    FIFTH_PLACE(3, false, 5_000L),
    FOURTH_PLACE(4, false, 50_000L),
    THIRD_PLACE(5, false, 1_500_000L),
    SECOND_PLACE(5, true, 30_000_000L),
    FIRST_PLACE(6, false, 2_000_000_000L);

    private final int matchCount;
    private final boolean bonus;
    private final Long winningMoney;

    LottoPrizeRules(int matchCount, boolean bonus, Long winningMoney) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }

    public boolean getBonus() {
        return bonus;
    }
}
