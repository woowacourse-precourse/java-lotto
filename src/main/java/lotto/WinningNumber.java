package lotto;

import lotto.util.Constant;

import java.text.DecimalFormat;
import java.util.Map;

public enum WinningNumber {
    THREE_MATCHES(3, 0, Constant.THREE_MATCHES_AMOUNT),
    FOUR_MATCHES(4, 0, Constant.FOUR_MATCHES_AMOUNT),
    FIVE_MATCHES(5, 0, Constant.FIVE_MATCHES_AMOUNT),
    FIVE_AND_BONUS_BALL_MATCHES(5, 1, Constant.FIVE_AND_BONUS_BALL_AMOUNT),
    SIX_MATCHES(6, 0, Constant.SIX_MATCHES_AMOUNT);

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

    public static void printNumberOfLotto(String guideMessage, int matchCount) {
        System.out.printf(guideMessage, matchCount);
    }

    public static int multiply(WinningNumber winningNumber, Map<WinningNumber, Integer> matchCount) {
        return winningNumber.getMoney() * matchCount.get(winningNumber);
    }

    public static boolean isEqualToBonusNumber(WinningNumber winningNumber) {
        return winningNumber.getNumberOfBonus() == WinningNumber.FIVE_AND_BONUS_BALL_MATCHES.getNumberOfBonus();
    }
}
