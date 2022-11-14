package lotto;

import java.util.List;

public class LottoWin {
    public static Integer getTotalPrize(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        int prizeMoney = 0;

        for (Lotto lotto : lottos) {
            prizeMoney += getPrizeMoney(lotto, luckyNums, bonusNum);
        }
        return prizeMoney;
    }
}
