package lotto.service;

import lotto.Ranking;

public class ChangeLottoPriceService {

    public ChangeLottoPriceService(){}

    public long changeRankingToPrice(Ranking ranking){
        return 1L;
    }

    private boolean isThreeMatch(Ranking ranking){
        return ranking.equals(Ranking.THREE_MATCH);
    }

    private boolean isFourMatch(Ranking ranking){
        return ranking.equals(Ranking.FOUR_MATCH);
    }

    private boolean isFiveMatch(Ranking ranking){
        return ranking.equals(Ranking.FIVE_MATCH);
    }

    private boolean isFiveMatchWithBonusNumber(Ranking ranking){
        return ranking.equals(Ranking.FIVE_MATCH_WITH_BONUS);
    }

    private boolean isSixMatch(Ranking ranking){
        return ranking.equals(Ranking.SIX_MATCH);
    }
}
