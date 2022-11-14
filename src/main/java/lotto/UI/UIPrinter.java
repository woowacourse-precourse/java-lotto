package lotto.UI;

import lotto.Lotto;
import lotto.UI.message.UIMessage;

public class UIPrinter {
    public static void printError(String error) {
        System.out.println("[ERROR] " + error);
    }

    public static void printEmptyLine() {
        System.out.println(UIMessage.EMPTY_LINE.getMessage());
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRank(String message, long money, int num) {
        System.out.printf(message, money, num);
    }

    public static void printProfit(String message, double profitRate) {
        System.out.printf(message, profitRate);
    }
}
