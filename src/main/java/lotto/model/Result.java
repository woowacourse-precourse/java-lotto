package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> result;

    public static Result of(List<Integer> ranks) {
        return new Result(ranks);
    }

    private Result(List<Integer> ranks) {
        this.result = new HashMap<>();
        initResult();
        store(ranks);
    }

    public long calculateProfit() {
        long profit=0;

        for (Rank rank : result.keySet()) {
            profit+= rank.calculateTotalPrize(result.get(rank));
        }

        return profit;
    }

    @Override
    public String toString() {
        StringBuilder resultStatics = new StringBuilder();

        for (Rank rank : Rank.values()) {
            resultStatics.append(rank.getDescription()+" - "+result.get(rank)+"개\n");
        }

        return resultStatics.toString();
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    private void store(List<Integer> ranks) {
        for (Integer rankValue : ranks) {
            Rank currentRank = Rank.valueOf(Rank.toRankName(rankValue));
            result.put(currentRank, result.get(currentRank)+1);
        }
    }
}
