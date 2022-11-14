package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
    Ranking ranking = new Ranking();
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String getLottosString(){
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbersString());
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private List<RankingType> getLottosRanking(WinningNumber winningNumber){
        List<RankingType> rankings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            RankingType ranking = this.ranking.getRanking(lotto, winningNumber);
            rankings.add(ranking);
        }
        return rankings;
    }

    public Map<RankingType, Integer> getCountByRankingType(WinningNumber winningNumber){
        Map<RankingType, Integer> countByRankingType = new HashMap<>();
        initCountByRankingType(countByRankingType);
        List<RankingType> lottosRanking = getLottosRanking(winningNumber);
        for (RankingType rankingType : lottosRanking) {
            int beforeCount = countByRankingType.get(rankingType);
            countByRankingType.put(rankingType, beforeCount + 1);
        }
        return countByRankingType;
    }

    private void initCountByRankingType(Map<RankingType, Integer> map){
        RankingType[] values = RankingType.values();
        for (RankingType value : values) {
            map.put(value, 0);
        }
    }
}
