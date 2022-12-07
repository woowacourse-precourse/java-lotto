package lotto.util;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.enums.Rank;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.enums.Rank.*;
import static lotto.enums.Rank.SECOND;

public class Statistics {

    private final Map<Rank, Integer> rank = setMap();
    private int reward = 0;
    private double profitRate = 0;
    public Map<Rank, Integer> setMap(){
        Map<Rank, Integer> map = new HashMap<>();
        map.put(FIRST, 0);
        map.put(SECOND, 0);
        map.put(THIRD, 0);
        map.put(FOURTH, 0);
        map.put(FIFTH, 0);
        map.put(MISS, 0);
        return map;
    }

    public void compareNumber(List<Lotto> randomLottos, WinLotto winLotto) {
        for (Lotto tmpLotto : randomLottos) {
            int countMatch = tmpLotto.matchCount(winLotto);
            boolean checkBonus = false;
            if (countMatch == SECOND.getCountOfMatch()) {
               checkBonus = checkBonusMatch(tmpLotto, winLotto);
            }
            Rank matchRank = Rank.getMatch(countMatch, checkBonus);
            rank.put(matchRank, rank.get(matchRank)+1);
        }
    }

    public boolean checkBonusMatch(Lotto other, WinLotto winLotto){
        if(winLotto.contains(other))return true;
        return false;
    }


    public void calculateProfitRate(Buyer buyer) {
        int profit = 0;
        for(Rank match: rank.keySet()){
            profit += rank.get(match)*match.getWinningMoney();
        }
        profitRate =Math.round((profit / (double) buyer.getBuyPrice() * 100) * 10) / 10.0;
    }

    @Override
    public String toString() {
        StringBuilder printStatistics = new StringBuilder();
        printStatistics.append("당첨통계\n");
        printStatistics.append("---\n");
        printStatistics.append("3개 일치 (5,000원) - ");
        printStatistics.append(rank.get(FIFTH)+"개\n");
        printStatistics.append("4개 일치 (50,000원) - ");
        printStatistics.append(rank.get(FOURTH)+"개\n");
        printStatistics.append("5개 일치 (1,500,000원) - ");
        printStatistics.append(rank.get(THIRD)+"개\n");
        printStatistics.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        printStatistics.append(rank.get(SECOND)+"개\n");
        printStatistics.append("6개 일치 (2,000,000,000원) - ");
        printStatistics.append(rank.get(FIRST)+"개\n");
        printStatistics.append("총 수익률은 "+ new DecimalFormat("###,###.0").format(profitRate)+"%입니다.");
        return printStatistics.toString();
    }
}
