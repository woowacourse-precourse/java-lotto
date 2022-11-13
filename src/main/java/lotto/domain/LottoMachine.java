package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

    public static Map<Prize, Integer> checkPrizes(Lotto winningNums, Lottos lottos,
        int bonus) {
        Map<Prize, Integer> prizeBoard = initPrizeBoard();
        for (Lotto lotto : lottos.lottos) {
            boolean isBonus = isBonus(lotto, bonus);
            int count = (int) lotto.getNumbers().stream()
                .filter(number -> winningNums.getNumbers().contains(number)).count();
            Prize prize = Prize.valueOf(count, isBonus);
            prizeBoard.put(prize, prizeBoard.get(prize) + 1);
        }
        return prizeBoard;
    }

    private static boolean isBonus(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }


    private static Map<Prize, Integer> initPrizeBoard() {
        Map<Prize, Integer> prizeBoard = new HashMap<>();
        Arrays.stream(Prize.values())
            .map(prize -> prizeBoard.put(prize, 0)).collect(Collectors.toList());
        return prizeBoard;
    }


}
