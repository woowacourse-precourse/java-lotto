package lotto.view.print;

import lotto.view.print.enums.GuideMessage;

public class PrintGuideMessage {
    public static void printStartGuide() {
        System.out.println(GuideMessage.AMOUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printPurchaseGuide(int quantity) {
        System.out.printf(GuideMessage.PURCHASE_MESSAGE.getMessage(), quantity);
    }

    public static void printWinningNumbersGuide() {
        System.out.println(GuideMessage.WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
    }

    public static void printBonusGuide() {
        System.out.println(GuideMessage.BONUS_INPUT_MESSAGE.getMessage());
    }

    public static void printStatisticsGuide() {
        System.out.println(GuideMessage.STATISTICS_MESSAGE.getMessage());
    }
}