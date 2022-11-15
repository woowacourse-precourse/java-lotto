package lotto;

import static lotto.Constant.*;
import static lotto.Constant.TOTAL_YIELD;
import static lotto.Game.nLottoPrice;
import static lotto.MatchNumber.*;

public class PrintLotto {
    public static void PrintWinning(int[] WinTypeCounter) {
        float prizeMoney = getPrizeMoney(WinTypeCounter);
        float getPercent = (prizeMoney / nLottoPrice) * 100;

        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCH + WinTypeCounter[win_5th] + PIECE);
        System.out.println(FOUR_MATCH + WinTypeCounter[win_4th] + PIECE);
        System.out.println(FIVE_MATCH + WinTypeCounter[win_3rd] + PIECE);
        System.out.println(FIVE_BONUS_MATCH + WinTypeCounter[win_2nd] + PIECE);
        System.out.println(SIX_MATCH + WinTypeCounter[win_1st] + PIECE);
        System.out.printf("%s %.1f%%입니다.", TOTAL_YIELD, getPercent);
    }

    public static int getPrizeMoney(int[] WinTypeCounter) {
        long sum;
        sum = WinTypeCounter[win_5th] * THREE.getPrize() + WinTypeCounter[win_4th] * FOUR.getPrize() +
                WinTypeCounter[win_3rd] * FIVE.getPrize() + WinTypeCounter[win_2nd] * FIVE_BONUS.getPrize() +
                WinTypeCounter[win_1st] * SIX.getPrize();
        return Long.valueOf(sum).intValue();
    }
}
