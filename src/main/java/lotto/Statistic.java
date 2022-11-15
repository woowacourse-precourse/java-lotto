package lotto;

import static lotto.matchedCountMessage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private Map<Integer,Integer> MatchedCount ;
    Statistic (){
        MatchedCount = new HashMap<>();
    }

    public Map<Integer, Integer> getStatistic(){
        return this.MatchedCount;
    }

    public void addMatchedCount(int number){
        MatchedCount.put(number, MatchedCount.get(number)+1);
    }

    public void score (List<Integer> WinningNumber, int bonusNumber, ArrayList<Lotto> lottos){
        for (Lotto lotto : lottos) {
            countEachLottoNumber(lotto, WinningNumber, bonusNumber);
        }
    }

    public int CountEachLottoWinningNumber(Lotto lotto, List<Integer> WinningNumber){
        List<Integer> lottoNumber = lotto.getLotto();
        int winningSum =0;
        for (int i = 0 ; i< lottoNumber.size() ; i++) {
            if(WinningNumber.contains(lottoNumber.get(i))) {
                winningSum++;
            }
        }
        return winningSum;
    }
    public boolean checkEachLottoBonusNumber(Lotto lotto, int bonusNumber){
        List<Integer> lottoNumber = lotto.getLotto();
        return lottoNumber.contains(bonusNumber);
    }
    public void countEachLottoNumber( Lotto lotto,List<Integer> WinningNumber, int bonusNumber){
        int winningSum = CountEachLottoWinningNumber(lotto, WinningNumber);
        if (winningSum == 5 && checkEachLottoBonusNumber(lotto, bonusNumber)) {
            addMatchedCount(FIVE_MATCH_WITH_BONUS.getMatchNumber());
            return;
        }
        addMatchedCount(winningSum);
    }

}
