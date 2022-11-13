package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoMarker {
    public static WinningStatistic produceWinningStatistic(LottoWinNo answer, Lotto ticket){
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
        return WinningStatistic.getInstance(numOfCorrectLottoNum,bonusNumCorrect);
    }
}
