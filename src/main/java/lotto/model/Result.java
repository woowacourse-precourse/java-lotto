package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> result = new EnumMap<LottoRank, Integer>(LottoRank.class);

    public Result(List<LottoRank> lottoRanks){
        putValues(lottoRanks);
    }

    private void putValues(List<LottoRank> lottoRanks){
        for(LottoRank lottoRank : lottoRanks){
            result.put(lottoRank, result.getOrDefault(lottoRank, 0)+1);
        }
    }

    public long calculatePrize() {
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().multiple(entry.getValue()))
                .sum();
    }

    public int getRankCount(LottoRank lottoRank) {
        return result.getOrDefault(lottoRank,0);
    }

    public float calculateProfit(LottoCount amount){
        return (float)this.calculatePrize()/(float)amount.getAmount() * 100;

    }
}
