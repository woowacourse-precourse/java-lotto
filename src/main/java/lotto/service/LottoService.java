package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;


public class LottoService {
    public static HashMap<Prize, Integer> lottoNumberComparison(List<Lotto> lotteryNumbers, LuckyNumber luckyNumber){
        HashMap<Prize, Integer> history = historyInit();

        for(Lotto userNumber : lotteryNumbers){
            List<Integer> userNum = userNumber.getNumbers();
            List<Integer> luckyNum = luckyNumber.getLuckyNumber().getNumbers();

            int matchN = matchN(userNum,luckyNum);
            int matchBonusN = matchBonusN(userNum, luckyNumber.getBonusNumber());

            Prize prize = Prize.winHistory(matchN,matchBonusN);
            history.replace(prize,history.get(prize)+1);
        }

        return history;
    }

    public static int matchN(List<Integer> userNumber, List<Integer> luckyNumber){
        int count= 0;
        for (Integer number : userNumber){
            if (luckyNumber.contains(number))
                count++;
        }
        return count;
    }

    public static int matchBonusN(List<Integer> userNumber, int bonusNumber){
        if(userNumber.contains(bonusNumber))
            return 1;
        return 0;
    }

    private static HashMap<Prize, Integer> historyInit(){
        HashMap<Prize, Integer> history = new HashMap<>();
        history.put(Prize.FIFTH_PLACE,0);
        history.put(Prize.FOURTH_PLACE,0);
        history.put(Prize.THIRD_PLACE,0);
        history.put(Prize.SECOND_PLACE,0);
        history.put(Prize.FIRST_PLACE,0);
        history.put(Prize.LOSING_TICKET,0);
        return history;
    }

}
