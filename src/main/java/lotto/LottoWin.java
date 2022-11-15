package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {
    public static Map<Integer, Integer> getPrizeMap(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        Map<Integer, Integer> prizeMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            Prize temp = getPrizeMoney(lotto, luckyNums, bonusNum);
            int tempRank = temp.getRank();
            if (tempRank > 0) {
                prizeMap.put(tempRank, prizeMap.getOrDefault(tempRank, 0) + 1);
            }
        }

        return prizeMap;
    }

    public static Prize getPrizeMoney(Lotto target, Lotto luckyNums, int bonusNum) {
        int winningNum = target.getWinningNum(luckyNums);
        boolean bonus = target.hasBonus(bonusNum);

        if (winningNum == 3) {
            return Prize.FIFTH;
        }
        if (winningNum == 4) {
            return Prize.FOURTH;
        }
        if (winningNum == 5 && !bonus) {
            return Prize.THIRD;
        }
        if (winningNum == 5 && bonus) {
            return Prize.SECOND;
        }
        if (winningNum == 6) {
            return Prize.FIRST;
        }
        return Prize.NOTHING;
    }
}
