package lotto;

import static lotto.Output.printWinningStatistic;
import static lotto.matchedCountMessage.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private static Map<Integer,Integer> MatchedCount ;

    Statistic (){
        MatchedCount = new LinkedHashMap<>();
    }

    public Map<Integer, Integer> getStatistic(){
        return this.MatchedCount;
    }

    public Integer getStatisticNumber(int number) {
        return this.MatchedCount.get(number);
    }

    public void addMatchedCount(int number){
       MatchedCount.put(number, MatchedCount.getOrDefault(number,0)+1);
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
        if (winningSum == FIVE_MATCH.getMatchNumber() && checkEachLottoBonusNumber(lotto, bonusNumber)) {
            addMatchedCount(FIVE_MATCH_WITH_BONUS.getMatchNumber());
            return;
        }
        if (winningSum >= THREE_MATCH.getMatchNumber() && winningSum <= SIX_MATCH.getMatchNumber())
            addMatchedCount(winningSum);
    }

    public static void printMatchedCount(){
        printWinningStatistic();
        for (matchedCountMessage message : matchedCountMessage.values()) {
            message.printMatchMessage(MatchedCount);
        }
    }


    public static double getProfit(int purchasedMoney) {
        double profit= 0;
        for (matchedCountMessage message : matchedCountMessage.values()) {
            profit += message.getMatchNumberPrice() * MatchedCount.getOrDefault(message.getMatchNumber(),0);
        }
        profit = ( profit / purchasedMoney)  * 100;
        return profit;
    }

}
