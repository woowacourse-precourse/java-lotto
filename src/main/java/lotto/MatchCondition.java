package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MatchCondition {


    public List<Integer> getMatchResult(List<Lotto> userLottoGroup, List<Integer> winningNumber, int bounsNumber){
        List<Integer> matchResult = new ArrayList<>(Arrays.asList(0,0,0,0,0));

        for(int i = 0; i<userLottoGroup.size(); i++){
            int placeCount = matchWithWinningNumbers(userLottoGroup.get(i).getNumbers(), winningNumber);
            boolean bonus = matchBonusNumber(bounsNumber,userLottoGroup);
            if(placeCount >= 3 ){
                int index = resultPlace(placeCount,bonus);
                matchResult.add(index, matchResult.get(index)+1 );
            }
        }
        return matchResult;
    }



    public int matchWithWinningNumbers(List<Integer> userLottos, List<Integer> winning){
        int matchPlace = 0;
        for(Integer number : userLottos){
            if(winning.contains(number)){
                matchPlace++;
            }
        }
        return matchPlace;
    }



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


