package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MatchCondition {



    public int resultPlace(int count, boolean bonus){
        if(count == 6){
            return 0;
        }
        if(count == 5 && bonus){
            return 1;
        }
        if(count == 5){
            return 2;
        }
        if(count == 4){
            return 3;
        }
        return 4;
    }


    public boolean matchBonusNumber(int bonusNumber, List<Lotto> userLottosNumber){
        int count = 0;
        for(int i = 0; i<userLottosNumber.size(); i++){
            List<Integer> sample = userLottosNumber.get(i).getNumbers();
            if(sample.contains(bonusNumber)){
                count ++;
            }
        }
        return count != 0;
    }


    public Double calculRateOfReturn(int money, List<Integer> placeResult){
        double profit = 0;

        for(MatchLotto result : MatchLotto.values()){
            profit +=(result.getPrize() * placeResult.get(result.getMatchNumber()));
        }
        return Math.round(profit/money *100)*1000 / 1000000.0;
    }
}


