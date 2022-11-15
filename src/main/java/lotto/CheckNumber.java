package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNumber {
    static void checkBonusWinnerNumber(Lotto lotto,int bonus){
        lotto.check_bonus(bonus);
    }
    static boolean checkContainsBonus(List<Integer> lottoNum, int bonus){
        if(lottoNum.contains(bonus)) return true;
        return false;
    }

}