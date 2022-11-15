package lotto.ui;

import lotto.utils.OutputMessage;

import java.util.List;

public class Output {
    public static void inputPurchaseAmountMessage() {
        System.out.println(OutputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public static void lottoCount(int count) {
        System.out.println("\n" + String.valueOf(count) + OutputMessage.LOTTO_COUNT.getMessage());
    }

    public static void sortedLotto(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void inputWinningNumberMessage() {
        System.out.println("\n" + OutputMessage.INPUT_WINNING_NUMBER.getMessage());
    }

    public static void inputBonusNumberMessage() {
        System.out.println("\n" + OutputMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public static void winningStatisticsMessage() {
        System.out.println("\n" + OutputMessage.WINNING_STATISTICS_MESSAGE.getMessage());
    }

    public static void winningStatistics(List<Integer> counts) {
        System.out.println(OutputMessage.WINNING_FIFTH.getMessage() + counts.get(4) + OutputMessage.WINNING_ALL_COUNT.getMessage());
        System.out.println(OutputMessage.WINNING_FOURTH.getMessage() + counts.get(3) + OutputMessage.WINNING_ALL_COUNT.getMessage());
        System.out.println(OutputMessage.WINNING_THIRD.getMessage() + counts.get(2) + OutputMessage.WINNING_ALL_COUNT.getMessage());
        System.out.println(OutputMessage.WINNING_SECOND.getMessage() + counts.get(1) + OutputMessage.WINNING_ALL_COUNT.getMessage());
        System.out.println(OutputMessage.WINNING_FIRST.getMessage() + counts.get(0) + OutputMessage.WINNING_ALL_COUNT.getMessage());
    }

    public static void rateOfReturn(Double rates) {
        System.out.println(OutputMessage.ALL_RATE_OF_RETURN.getMessage() + String.format("%.2f", rates) + OutputMessage.END_RATE_OF_RETURN.getMessage());
    }
}
