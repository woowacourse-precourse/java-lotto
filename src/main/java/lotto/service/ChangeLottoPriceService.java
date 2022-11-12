package lotto.service;

import lotto.Ranking;

public class ChangeLottoPriceService {

    private static final long PRICE_FOR_THREE_MATCH = 5000L;
    private static final long PRICE_FOR_FOUR_MATCH = 50000L;
    private static final long PRICE_FOR_FIVE_MATCH = 1500000L;
    private static final long PRICE_FOR_FIVE_MATCH_WITH_BONUS = 30000000L;
    private static final long PRICE_FOR_SIX_MATCH = 2000000000L;
    private static final long NOTHING = 0L;

    public ChangeLottoPriceService(){}

    public long changeRankingToPrice(Ranking ranking){
        if(isThreeMatch(ranking)) return PRICE_FOR_THREE_MATCH;
        if(isFourMatch(ranking)) return PRICE_FOR_FOUR_MATCH;
        if(isFiveMatch(ranking)) return PRICE_FOR_FIVE_MATCH;
        if(isFiveMatchWithBonusNumber(ranking)) return PRICE_FOR_FIVE_MATCH_WITH_BONUS;
        if(isSixMatch(ranking)) return PRICE_FOR_SIX_MATCH;
        return NOTHING;
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
