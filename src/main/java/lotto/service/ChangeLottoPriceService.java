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
        return false;
    }

    private boolean isFiveMatchWithBonusNumber(Ranking ranking){
        return false;
    }

    private boolean isSixMatch(Ranking ranking){
        return false;
    }
}
