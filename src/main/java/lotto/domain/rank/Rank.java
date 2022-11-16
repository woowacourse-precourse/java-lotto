package lotto.domain.rank;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rank {
    private final Map<RankInfo, Integer> rank;

    public Rank() {
        this.rank = new LinkedHashMap<>();
        rank.put(RankInfo.FIFTH, 0);
        rank.put(RankInfo.FOURTH, 0);
        rank.put(RankInfo.THIRD, 0);
        rank.put(RankInfo.SECOND, 0);
        rank.put(RankInfo.FIRST, 0);
        rank.put(RankInfo.OTHERS, 0);
    }

    public Map<RankInfo, Integer> getRank() {
        return rank;
    }

    public void count(int rank){
        RankInfo key = RankInfo.values()[rank];
        Integer cnt = this.rank.get(key);
        this.rank.put(key, cnt + 1);
    }
}
