package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Winning {
    private static List<Integer> winningResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public static void checkWinning(int ticketAmount) {
        List<List<Integer>> lottos = DrawNumber.lottos;
        List<Integer> luckySix = LuckyNumber.luckySix;
        int luckyBonus = LuckyNumber.luckyBonus;

        for (int index = 0; index < ticketAmount; index++) {
            List<Integer> oneLotto = lottos.get(index);
            List<Integer> sameNumber = luckySix.stream()
                    .filter(lucky -> oneLotto.stream().anyMatch(Predicate.isEqual(lucky)))
                    .collect(Collectors.toList());
            if (sameNumber.size() == 3) {
                winningResult.set(0, winningResult.get(0) + 1);
            }
            if (sameNumber.size() == 4) {
                winningResult.set(1, winningResult.get(1) + 1);
            }
            if (sameNumber.size() == 5) {
                if (oneLotto.contains(luckyBonus)) {
                    winningResult.set(3, winningResult.get(3) + 1);
                } else {
                    winningResult.set(2, winningResult.get(2) + 1);
                }
            }

            if (sameNumber.size() == 6) {
                winningResult.set(4, winningResult.get(4) + 1);
            }
        }
    }

    public static void printWinningResult() {
        System.out.println(GameMessage.STATISTIC_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_3_RESULT_MESSAGE.getMessage() + Integer.toString(winningResult.get(0)) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_4_RESULT_MESSAGE.getMessage() + Integer.toString(winningResult.get(1)) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_5_RESULT_MESSAGE.getMessage() + Integer.toString(winningResult.get(2)) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_5BONUS_RESULT_MESSAGE.getMessage() + Integer.toString(winningResult.get(3)) + GameMessage.COUNT_MESSAGE.getMessage());
        System.out.println(GameMessage.WINNING_6_RESULT_MESSAGE.getMessage() + Integer.toString(winningResult.get(4)) + GameMessage.COUNT_MESSAGE.getMessage());
    }


}
