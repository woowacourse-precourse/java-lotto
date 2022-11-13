package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoMarker {
    public static LottoResult produceWinningStatistic(LottoWinNumber answer, Lotto ticket){
        Set<Integer> answerNumSet=new HashSet<>(answer.getNumbers());
        int numOfCorrectLottoNum=0;
        boolean bonusNumCorrect=false;
        if(answerNumSet.contains(answer.getBonusNum())){
            bonusNumCorrect=true;
        }
        for (int number :ticket.getNumbers()){
            if(answerNumSet.contains(number)){
                numOfCorrectLottoNum+=1;
                answerNumSet.remove(number);
            }
        }
        return LottoResult.getInstance(numOfCorrectLottoNum,bonusNumCorrect);
    }
}
