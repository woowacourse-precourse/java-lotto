package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Bonus.BonusNumber;
import static lotto.Constant.*;
import static lotto.Count.*;
import static lotto.Count.WinningCount;
import static lotto.MakeLotto.*;
import static lotto.PrintLotto.*;

public class Game {

    public static final List<List<Integer>> GeneratedLotto = new ArrayList<>();
    public static int nLottoPrice;
    public static List<Integer> JackpotNumbers = new ArrayList<>();
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
        JackpotNumbers = inputJackpotNum();
        Bonus.askBonusNumber();
        WinningCount(GeneratedLotto, JackpotNumbers);
        PrintWinning(WinTypeCounter);
    }
}
