package lotto.domain;

import lotto.Ranking;

import java.util.HashMap;

public class Winning {
    private final HashMap<Ranking, Integer> score = new HashMap<>();

    public Winning(){
        initializeScore();
    }

    public void addRankingOfPlayer(Ranking lottoRanking){
        int lottoRankingCount = score.get(lottoRanking);
        score.replace(lottoRanking, lottoRankingCount, lottoRankingCount+1);
    }

    public HashMap<Ranking, Integer> figureSameRanking(){
        return score;
    }

    private void initializeScore(){
        score.put(Ranking.NOTHING, 0);
        score.put(Ranking.THREE_MATCH, 0);
        score.put(Ranking.FOUR_MATCH, 0);
        score.put(Ranking.FIVE_MATCH, 0);
        score.put(Ranking.FIVE_MATCH_WITH_BONUS, 0);
        score.put(Ranking.SIX_MATCH, 0);
    }
}
