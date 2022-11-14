package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {
    public static Map<Integer, Integer> getPrizeMap(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        Map<Integer, Integer> prizeMap = new HashMap<>();
        int tempMoney = 0;

        for (Lotto lotto : lottos) {
            tempMoney = getPrizeMoney(lotto, luckyNums, bonusNum);
            prizeMap.put(tempMoney, prizeMap.getOrDefault(tempMoney, 0) + 1);
        }

        return prizeMap;
    }

    public static Integer getPrizeMoney(Lotto target, Lotto luckyNums, int bonusNum) {
        int winningNum = target.getWinningNum(luckyNums);
        boolean bonus = target.hasBonus(bonusNum);

        if (winningNum == 3) {
            return Prize.FIFTH.getPrize();
        }
        if (winningNum == 4) {
            return Prize.FOURTH.getPrize();
        }
        if (winningNum == 5 && !bonus) {
            return Prize.THIRD.getPrize();
        }
        if (winningNum == 5 && bonus) {
            return Prize.SECOND.getPrize();
        }
        if (winningNum == 6) {
            return Prize.FIRST.getPrize();
        }
        return Prize.NOTHING.getPrize();
    }
}
