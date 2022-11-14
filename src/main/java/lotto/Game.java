package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;
import static lotto.Count.*;
import static lotto.Count.WinningCount;
import static lotto.MakeLotto.*;

public class Game {
    public static final List<List<Integer>> GeneratedLotto = new ArrayList<>();
    public static int nLottoPrice;
    public static int nLotto;

    public static List<Integer> inputJackpotNum() {
        System.out.println(ASK_WINNING_NUMBER);
        String winning = Console.readLine();
        String[] winningNumbers = winning.split(",");

        List<Integer> JackpotNumbers = new ArrayList<>();
        for (String winningNum : winningNumbers) {
            JackpotNumbers.add(Integer.parseInt(winningNum));
        }
        return JackpotNumbers;
    }

    public void Jackpot() {
        LottoGenerator(Buy.HowMuch());
        PrintGeneratedLotto(nLotto, GeneratedLotto);
        List<Integer> JackpotNumbers = inputJackpotNum();

        Bonus.askBonusNumber();
        int[] countBonus = BonusCount(GeneratedLotto);

        List<Integer> winCounts = WinningCount(GeneratedLotto, JackpotNumbers);
        //System.out.println(counts);
        int[] WinTypeCounter = prize(winCounts, countBonus);
        PrintWinning(WinTypeCounter);
    }

    public int[] prize(List<Integer> WinningCount, int[] countBonus) {
        int counterSize = 5;
        int[] WinTypeCounter = new int[counterSize];
        for (int i = 0; i < WinningCount.size(); i++) {
            if (WinningCount.get(i) == 3) {
                WinTypeCounter[0] += 1;
            } else if (WinningCount.get(i) == 4) {
                WinTypeCounter[1] += 1;
            } else if (WinningCount.get(i) == 5 && countBonus[i] == 1) {
                WinTypeCounter[3] += 1;
            } else if (WinningCount.get(i) == 5) {
                WinTypeCounter[2] += 1;
            } else if (WinningCount.get(i) == 6) {
                WinTypeCounter[4] += 1;
            }
        }
        /**
         for (int i = 0; i < WinTypeCounter.length; i++) {    //counter 출력중
         System.out.print(WinTypeCounter[i]);
         }**/
        return WinTypeCounter;
    }

    public void PrintWinning(int[] WinTypeCounter) {
        float prizeMoney = getPrizeMoney(WinTypeCounter);
        float getPercent = (prizeMoney / nLottoPrice) * 100;

        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCH + WinTypeCounter[0] + PIECE);
        System.out.println(FOUR_MATCH + WinTypeCounter[1] + PIECE);
        System.out.println(FIVE_MATCH + WinTypeCounter[2] + PIECE);
        System.out.println(FIVE_BONUS_MATCH + WinTypeCounter[3] + PIECE);
        System.out.println(SIX_MATCH + WinTypeCounter[4] + PIECE);
        System.out.println(TOTAL_YIELD + (Math.round(getPercent * 100) / 100.0) + "%입니다.");
    }

    public int getPrizeMoney(int[] WinTypeCounter) {
        int sum;
        sum = WinTypeCounter[0] * 5000 + WinTypeCounter[1] * 50000 + WinTypeCounter[2] * 1500000 +
                WinTypeCounter[3] * 30000000 + WinTypeCounter[4] * 2000000000;
        return sum;
    }
}
