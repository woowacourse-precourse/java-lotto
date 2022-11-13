package lotto;

import java.util.List;

import static lotto.BonusInputException.*;
import static lotto.MoneyInputException.moneyChangeError;
import static lotto.MoneyInputException.moneyTypeError;
import static lotto.WinNumInputException.*;

public class Exception {

    public static void moneyInputCheck(String input) {
        moneyTypeError(input);
        int money = Integer.parseInt(input);
        moneyChangeError(money);
    }

    public static void bonusErrorCheck(List<Integer> winNums, String input) {
        bonusTypeError(input);
        int bonus = Integer.parseInt(input);
        bonusRangeError(bonus);
        bonusDuplicate(winNums, bonus);
    }


    public static void winNumInputErrorCheck(String input) {
        winNumFormatError(input);
        String[] tmpNums = input.split(",");
        winNumDuplicate(tmpNums);
        for (String e : tmpNums) {
            winNumTypeError(e);
            int num = Integer.parseInt(e);
            winNumRangeError(num);
        }
    }
}
