package lotto;

import java.util.Map;

public enum WinningNumber {
    THREE_MATCHES(3, 0, 5000),
    FOUR_MATCHES(4, 0, 50000),
    FIVE_MATCHES(5, 0, 1500000),
    FIVE_AND_BONUS_BALL_MATCHES(5, 1, 30000000),
    SIX_MATCHES(6, 0, 2000000000);

    private final int numberOfWinning;
    private final int numberOfBonus;
    private final int money;

    WinningNumber(int numberOfWinning, int numberOfBonus, int money) {
        this.numberOfWinning = numberOfWinning;
        this.numberOfBonus = numberOfBonus;
        this.money = money;
    }

    public int getNumberOfWinning() {
        return numberOfWinning;
    }

    public int getNumberOfBonus() {
        return numberOfBonus;
    }

    public int getMoney() {
        return money;
    }

    public static void count(Map<WinningNumber, Integer> amountCount, int winningCount, int bonusCount) {
        WinningNumber key = getKey(amountCount, winningCount, bonusCount);
        if (key != null) {
            amountCount.put(key, amountCount.get(key) + 1);
        }
    }

    private static WinningNumber getKey(Map<WinningNumber, Integer> amountCount, int winningCount, int bonusCount) {
        for (WinningNumber key : amountCount.keySet()) {
            if (key.numberOfWinning == winningCount && key.numberOfBonus == bonusCount) {
                return key;
            }
        }
        return null;
    }
}
