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

    static int sum_price(int price,float result){
        for(RankSystem.RankType r: RankSystem.RankType.values()){
            if(r.getNum()==result){
                price += r.getPrice();
            }
        }
        return price;
    }
    static void viewResult(Lotto lotto, List<List<Integer>> lottoNums, int bonus,int money){
        List<Integer> CountWinLottos = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
        float result;
        int price = 0;
        List<Integer> temp;

        for (int i = 0;i < lottoNums.size();i++){
            temp = lottoNums.get(i);
            result = winCheckNum(lotto,temp,bonus);
            CountWinLottos = setWinLottos(CountWinLottos,result);
            price = sum_price(price,result);
        }
        output.outputResult(CountWinLottos);
        output.ownPrice(price,money);
    }
}