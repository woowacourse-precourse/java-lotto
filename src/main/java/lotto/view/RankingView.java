package lotto.view;

import lotto.Ranking;
import lotto.domain.Profit;
import lotto.domain.Winning;

import java.util.HashMap;

public class RankingView {
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String THREE_MATCH_COMMENT = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCH_COMMENT = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCH_COMMENT = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_MATCH_WITH_BONUS_COMMENT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCH_COMMENT = "6개 일치 (2,000,000,000원) - ";
    private static final String TELL_COUNT = "개";
    private static final String TOTAL_PROFIT_START = "총 수익률은 ";
    private static final String TOTAL_PROFIT_END = "%입니다.";

    public void showWinningResult(){

    }

    private void startWinningStatistics(){
        System.out.println(WINNING_STATISTICS);
    }

    private void showPriceToPlayer(HashMap<Ranking, Integer> score){
        System.out.println(THREE_MATCH_COMMENT + score.get(Ranking.THREE_MATCH) + TELL_COUNT);
        System.out.println(FOUR_MATCH_COMMENT + score.get(Ranking.FOUR_MATCH) + TELL_COUNT);
        System.out.println(FIVE_MATCH_COMMENT + score.get(Ranking.FIVE_MATCH) + TELL_COUNT);
        System.out.println(FIVE_MATCH_WITH_BONUS_COMMENT + score.get(Ranking.FIVE_MATCH_WITH_BONUS) + TELL_COUNT);
        System.out.println(SIX_MATCH_COMMENT + score.get(Ranking.SIX_MATCH) + TELL_COUNT);
    }

    private void showProfit(Profit profit){
        System.out.println(TOTAL_PROFIT_START + profit.getProfit() + TOTAL_PROFIT_END);
    }

}
