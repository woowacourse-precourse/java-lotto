package lotto.Domain.Statistic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticCalculate {

    int hasBonusSize(Set<Integer> publishedLottoNums , List<Integer> lottoSix, int bonus) {
        Set<Integer> removedBonus = new HashSet<>(publishedLottoNums);
        for(Integer publishedLottoNum : publishedLottoNums ) {
            if(bonus == publishedLottoNum) {
               removedBonus.remove(bonus);
               removedBonus.addAll(lottoSix);
               return removedBonus.size();
            }
        }
        return 0;
    }


    int hasNoBonusSize(Set<Integer> publishedLottoNums , List<Integer> lottoSix, int bonus) {
        int hasBonus = 0;
        for(Integer publishedLottoNum : publishedLottoNums ) {
            if(bonus == publishedLottoNum) {
                hasBonus++;
            }
        }
        if(hasBonus==0){
                publishedLottoNums.addAll(lottoSix);
                return publishedLottoNums.size();
        }
        return 0;
    }

}
