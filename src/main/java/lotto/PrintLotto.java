package lotto;

import java.util.List;

import static lotto.Constant.*;
import static lotto.Constant.TOTAL_YIELD;
import static lotto.Game.nLottoPrice;
import static lotto.MatchNumber.*;

public class PrintLotto {
    public static void PrintWinning(int[] WinTypeCounter) {
        float prizeMoney = getPrizeMoney(WinTypeCounter);
        float getPercent = (prizeMoney / nLottoPrice) * 100;

        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCH + WinTypeCounter[5] + PIECE);
        System.out.println(FOUR_MATCH + WinTypeCounter[4] + PIECE);
        System.out.println(FIVE_MATCH + WinTypeCounter[3] + PIECE);
        System.out.println(FIVE_BONUS_MATCH + WinTypeCounter[2] + PIECE);
        System.out.println(SIX_MATCH + WinTypeCounter[1] + PIECE);
        System.out.printf("%s %.1f%%입니다.",TOTAL_YIELD,getPercent);
    }

    public static int getPrizeMoney(int[] WinTypeCounter) {
        long sum;
        sum = WinTypeCounter[5] * THREE.getPrize() + WinTypeCounter[4] * FOUR.getPrize() + WinTypeCounter[3] * FIVE.getPrize() +
                WinTypeCounter[2] * FIVE_BONUS.getPrize() + WinTypeCounter[1] * SIX.getPrize();
        return Long.valueOf(sum).intValue();
    }
}
