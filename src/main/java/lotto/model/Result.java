package lotto.model;

import static lotto.constant.ResultConstants.DEFAULT_VALUE;
import static lotto.constant.ResultConstants.DELIMITER;
import static lotto.constant.ResultConstants.INCREASE_AMOUNT;
import static lotto.constant.ResultConstants.NEW_LINE;
import static lotto.constant.ResultConstants.UNIT;

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
        long profit=DEFAULT_VALUE;

        for (Rank rank : result.keySet()) {
            profit+= rank.calculateTotalPrize(result.get(rank));
        }

        return profit;
    }

    @Override
    public String toString() {
        StringBuilder resultStatics = new StringBuilder();

        for (Rank rank : Rank.values()) {
            resultStatics.append(rank.getDescription()+DELIMITER+result.get(rank)+UNIT+NEW_LINE);
        }

        return resultStatics.toString();
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_VALUE);
        }
    }

    private void store(List<Integer> ranks) {
        for (Integer rankValue : ranks) {
            Rank currentRank = Rank.valueOf(Rank.toRankName(rankValue));
            result.put(currentRank, result.get(currentRank)+INCREASE_AMOUNT);
        }
    }
}
