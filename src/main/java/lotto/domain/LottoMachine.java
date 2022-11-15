package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int COUNT = 1;
    private static final int INIT_NUMBER = 0;

    public static Map<Prize, Integer> checkPrizes(Lotto winningNums, Lottos lottos,
        Bonus bonus) {
        Map<Prize, Integer> prizeBoard = initPrizeBoard();
        cycleLottos(winningNums, lottos, bonus, prizeBoard);
        return prizeBoard;
    }

    private static void cycleLottos(Lotto winningNums, Lottos lottos, Bonus bonus,
        Map<Prize, Integer> prizeBoard) {
        for (Lotto lotto : lottos.lottos) {
            boolean isBonus = isBonus(lotto, bonus);
            int count = countPerRank(winningNums, lotto);
            Prize prize = Prize.valueOf(count, isBonus);
            putPrize(prizeBoard, prize);
        }
    }

    private static Integer putPrize(Map<Prize, Integer> prizeBoard, Prize prize) {
        return prizeBoard.put(prize, addPrizeCount(prizeBoard, prize));
    }

    private static int countPerRank(Lotto winningNums, Lotto lotto) {
        return Lotto.countCommonNumber(winningNums, lotto);
    }

    private static int addPrizeCount(Map<Prize, Integer> prizeBoard, Prize prize) {
        return prizeBoard.get(prize) + COUNT;
    }

    private static boolean isBonus(Lotto lotto, Bonus bonus) {
        return Lotto.isBonus(lotto, bonus);
    }


    private static Map<Prize, Integer> initPrizeBoard() {
        Map<Prize, Integer> prizeBoard = new HashMap<>();
        Arrays.stream(Prize.values())
            .map(prize -> prizeBoard.put(prize, INIT_NUMBER)).collect(Collectors.toList());
        return prizeBoard;
    }


}
