package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    public static List<Integer> winningResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public Winning(int ticketAmount) {
        checkWinning(ticketAmount);
        printWinningResult();
    }

    private void checkWinning(int ticketAmount) {
        for (int index = 0; index < ticketAmount; index++) {
            int sameNumber = DrawNumber.lottos.get(index).hasSameElement(LuckySix.luckySix);
            if (sameNumber == 3) {
                winningResult.set(0, winningResult.get(0) + 1);
            }
            if (sameNumber == 4) {
                winningResult.set(1, winningResult.get(1) + 1);
            }
            if (sameNumber == 5) {
                if (DrawNumber.lottos.get(index).isIncludeBonus(LuckyBonus.luckyBonus)) {
                    winningResult.set(3, winningResult.get(3) + 1);
                } else {
                    winningResult.set(2, winningResult.get(2) + 1);
                }
            }
            if (sameNumber == 6) {
                winningResult.set(4, winningResult.get(4) + 1);
            }
        }
    }

    private static void printWinningResult() {
        System.out.println(GameMessage.STATISTIC_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_3_RESULT_MESSAGE.getMessage() + winningResult.get(0) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_4_RESULT_MESSAGE.getMessage() + winningResult.get(1) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_5_RESULT_MESSAGE.getMessage() + winningResult.get(2) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_5BONUS_RESULT_MESSAGE.getMessage() + winningResult.get(3) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_6_RESULT_MESSAGE.getMessage() + winningResult.get(4) + GameMessage.COUNT_MESSAGE.getMessage());
    }


}
