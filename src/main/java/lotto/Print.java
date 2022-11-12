package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Print {
    private static final String contour = "---";

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

    public static void matchResult(Map<WinningNumber, Integer> matchCount) {
        System.out.printf(GuideMessage.WINNING_STATISTICS);
        System.out.println(contour);

        for (WinningNumber winningNumber : matchCount.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList())) {
            String amountMessage = getAmountMessage(winningNumber);
            System.out.printf(amountMessage + GuideMessage.MATCH_NUMBER,
                    winningNumber.getNumberOfWinning(), winningNumber.getMoney(), matchCount.get(winningNumber));
        }
    }

    private static String getAmountMessage(WinningNumber winningNumber) {
        if (winningNumber.getNumberOfBonus() == WinningNumber.FIVE_AND_BONUS_BALL_MATCHES.getNumberOfBonus()) {
            return GuideMessage.MATCH + ", " + GuideMessage.BONUS_BALL_MATCH + GuideMessage.AMOUNT;
        }
        return GuideMessage.MATCH + GuideMessage.AMOUNT;
    }
}
