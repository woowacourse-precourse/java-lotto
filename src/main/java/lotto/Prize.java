package lotto;

import java.util.List;

public enum Prize {
    THREE_MATCH(3, 0, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 0, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 0, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS_MATCH(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 0, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int winningCount;
    private final int bonusCount;
    private final int prizeMoney;
    private final String message;

    Prize(int winningCount, int bonusCount, int prizeMoney, String message) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static List<Prize> getAllPrize() {
        return List.of(Prize.values());
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

}
