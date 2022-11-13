package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoMarker {
    public static LottoResult produceWinningStatistic(LottoWinNumber answer, Lotto ticket){
        Set<Integer> answerNumberSet=new HashSet<>(answer.getNumbers());
        Set<Integer> ticketNumberSet=new HashSet<>(ticket.getNumbers());
        boolean bonusNumberCorrect=false;
        if (ticketNumberSet.contains(answer.getBonusNum())){
            bonusNumberCorrect=true;
        }
        Set<Integer> intersection=new HashSet<>(answerNumberSet);
        intersection.retainAll(ticketNumberSet);
        int numberOfCorrectLottoNumbers=intersection.size();
        return LottoResult.getInstance(numberOfCorrectLottoNumbers,bonusNumberCorrect);
    }
}
