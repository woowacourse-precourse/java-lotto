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
    static float winCheckNum(Lotto lotto,List<Integer> lottoNum,int bonus){
        float result;
        result = lotto.check_rank(lottoNum);
        if(result == 5){
            if(checkContainsBonus(lottoNum,bonus)) result = result + 0.5f;
        }
        return result;
    }


    static List<Integer> setWinLottos (List<Integer> CountWinLottos, float result){
        int index;
        int count;

        for(RankSystem.RankType r: RankSystem.RankType.values()){
            if(r.getNum()==result){
                index = r.getIndex();
                count = CountWinLottos.get(index);
                CountWinLottos.set(index, count + 1);
            }
        }
        return CountWinLottos;
    }

}