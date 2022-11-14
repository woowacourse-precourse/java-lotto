package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {
    public static Map<Prize, Integer> getPrizeMap(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        Map<Prize, Integer> prizeMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            Prize tempMoney = getPrizeMoney(lotto, luckyNums, bonusNum);
            prizeMap.put(tempMoney, prizeMap.getOrDefault(tempMoney, 0) + 1);
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
