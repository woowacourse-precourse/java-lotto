package lotto.util;

import lotto.Lotto;
import lotto.WinningNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Print {
    public static void purchaseMessage() {
        System.out.println(GuideMessage.ENTER_PURCHASE_AMOUNT);
    }

    public static void lottery(List<Lotto> lottery) {
        System.out.println(lottery.size() + GuideMessage.CONFIRM_PURCHASE_AMOUNT);

        for (Lotto lotto : lottery) {
            lotto.print();
        }
    }

    public static void enterWinningNumberMessage() {
        System.out.printf(GuideMessage.ENTER_WINNING_NUMBER);
    }

    public static void enterBonusNumberMessage() {
        System.out.printf(GuideMessage.ENTER_BONUS_NUMBER);
    }

    public static void matchResult(Map<WinningNumber, Integer> matchCount, int numberOfLotto) {
        System.out.printf(GuideMessage.WINNING_STATISTICS);
        System.out.println(GuideMessage.CONTOUR);

        for (WinningNumber winningNumber : matchCount.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList())) {
            WinningNumber.printNumberOfMatch(getAmountMessage(winningNumber), winningNumber);
            WinningNumber.printNumberOfLotto(GuideMessage.MATCH_NUMBER, matchCount.get(winningNumber));
        }
        System.out.printf(GuideMessage.FINAL_REVENUE, calculateYield(numberOfLotto, getRevenue(matchCount)));
    }

    private static String getAmountMessage(WinningNumber winningNumber) {
        if (WinningNumber.isEqualToBonusNumber(winningNumber)) {
            return GuideMessage.MATCH + ", " + GuideMessage.BONUS_BALL_MATCH + GuideMessage.AMOUNT;
        }
        return GuideMessage.MATCH + GuideMessage.AMOUNT;
    }

    private static int getRevenue(Map<WinningNumber, Integer> matchCount) {
        int sum = 0;
        for (WinningNumber winningNumber : matchCount.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList())) {
            sum += WinningNumber.multiply(winningNumber, matchCount);
        }
        return sum;
    }

    private static double calculateYield(int numberOfLotto, int revenue) {
        return (double) revenue / (numberOfLotto * Constant.LOTTO_PRICE) * 100;
    }
}
