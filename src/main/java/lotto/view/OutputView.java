package lotto.view;

import lotto.model.Lottos;
import lotto.model.WinningResult;
import lotto.model.enums.GameMessage;

import java.util.List;

public class OutputView {
    public static void showTicketAmount(int ticketAmount) {
        System.out.println(ticketAmount+GameMessage.PURCHASE_MESSAGE.getMessage());
    }

    public static void showDrawNumber(Lottos lottos) {
        lottos.printLottos();
    }

    public static void showWinningResult(List<Integer> winningResult) {
        System.out.println(GameMessage.STATISTIC_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_3_RESULT_MESSAGE.getMessage() + winningResult.get(0) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_4_RESULT_MESSAGE.getMessage() + winningResult.get(1) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_5_RESULT_MESSAGE.getMessage() + winningResult.get(2) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_5BONUS_RESULT_MESSAGE.getMessage() + winningResult.get(3) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_6_RESULT_MESSAGE.getMessage() + winningResult.get(4) + GameMessage.COUNT_MESSAGE.getMessage());
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(GameMessage.PROFIT_HEAD_MESSAGE.getMessage() + profitRate + GameMessage.PROFIT_TAIL_MESSAGE.getMessage());
    }
}
