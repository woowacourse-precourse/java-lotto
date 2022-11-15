package View;

public class GuideMessage {
    public static void printGetPayment() {
        print(enumCollections.GuideMessage.PURCHASE_INPUT);
    }

    public static void printGetWinningNumbers() {
        print(enumCollections.GuideMessage.WINNING_NUMBERS_INPUT);
    }

    public static void printGetBonusNumber() {
        print(enumCollections.GuideMessage.BONUS_NUMBER_INPUT);
    }

    public static void print(enumCollections.GuideMessage situation) {
        System.out.println(enumCollections.GuideMessage.getMessage(situation));
    }
}
