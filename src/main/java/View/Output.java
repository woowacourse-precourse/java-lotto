package View;

import enumCollections.GuideMessage;

public class Output {
    public static void getPurchaseAmount() {
        getGuideMessage(GuideMessage.PURCHASE_INPUT);
    }

    public static void getNumberOfPurchase(int number) {
        getGuideMessage(GuideMessage.NUMBER_OF_PURCHASE, number);
    }

    public static void getWinningNumbers() {
        getGuideMessage(GuideMessage.WINNING_NUMBERS_INPUT);
    }

    public static void getGuideMessage(GuideMessage message) {
        System.out.println(message);
    }

    public static void getGuideMessage(GuideMessage message, int value) {
        System.out.println(Integer.toString(value) + message);
    }
}
