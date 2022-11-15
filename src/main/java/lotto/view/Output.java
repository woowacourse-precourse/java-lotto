package lotto.view;

public class Output {
    public static void printStartMsg() {
        System.out.println(lotto.constants.Output.PURCHASE_AMOUNT_INPUT.getMsg());
    }

    public static void printPurchaseMsg(int number) {
        System.out.println(number + lotto.constants.Output.PURCHASE_AMOUNT_OUTPUT.getMsg());
    }

    public static void printWinningMsg() {
        System.out.println(lotto.constants.Output.WINNING_NUMBER_INPUT.getMsg());
    }

    public static void printBonusMsg() {
        System.out.println(lotto.constants.Output.BONUS_NUMBER_INPUT.getMsg());
    }
}
