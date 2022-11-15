package View;

public class GuideMessage {
    public static void printPaymentInput() {
        print(enumCollections.GuideMessage.PURCHASE_INPUT);
    }

    public static void printWinningNumbersInput() {
        printNewLine();
        print(enumCollections.GuideMessage.WINNING_NUMBERS_INPUT);
    }

    public static void printBonusNumberInput() {
        printNewLine();
        print(enumCollections.GuideMessage.BONUS_NUMBER_INPUT);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void print(enumCollections.GuideMessage situation) {
        System.out.println(enumCollections.GuideMessage.getMessage(situation));
    }
}
