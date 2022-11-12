package lotto;

import java.text.DecimalFormat;
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

    private int getNumberOfWinning() {
        return numberOfWinning;
    }

    private int getNumberOfBonus() {
        return numberOfBonus;
    }

    private int getMoney() {
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
            if ((key.equals(FIVE_MATCHES) || key.equals(FIVE_AND_BONUS_BALL_MATCHES))
                    && (key.numberOfWinning == winningCount && key.numberOfBonus == bonusCount)) {
                return key;
            }
            if (!(key.equals(FIVE_MATCHES) || key.equals(FIVE_AND_BONUS_BALL_MATCHES))
                    && key.numberOfWinning == winningCount) {
                return key;
            }
        }
        return null;
    }

    public static void printNumberOfMatch(String amountMessage, WinningNumber winningNumber) {
        System.out.printf(amountMessage, winningNumber.getNumberOfWinning(), insertComma(winningNumber.getMoney()));
    }

    private static String insertComma(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###,###");
        return decimalFormat.format(money);
    }

    public static void printNumberOfLotto(String guideMessage, WinningNumber winningNumber, int matchCount) {
        System.out.printf(guideMessage, matchCount);
    }

    public static int multiply(WinningNumber winningNumber, Map<WinningNumber, Integer> matchCount) {
        return winningNumber.getMoney() * matchCount.get(winningNumber);
    }

    public static boolean isEqualToBonusNumber(WinningNumber winningNumber) {
        return winningNumber.getNumberOfBonus() == WinningNumber.FIVE_AND_BONUS_BALL_MATCHES.getNumberOfBonus();
    }
}
