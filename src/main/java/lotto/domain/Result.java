package lotto.domain;

import static lotto.Constant.LOTTO_PRICE;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        result = new TreeMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public void record(Integer duplicatedCnt, boolean hasBonusNumber) {
        Rank rank = Rank.valueOf(duplicatedCnt, hasBonusNumber);
        result.put(rank, result.get(rank) + 1);
    }

    public Double calculateYield() {
        Integer totalOutcome = 0;
        Integer totalInput = 0;
        for (Rank rank : result.keySet()) {
            Integer rankCnt = result.get(rank);
            totalOutcome += rank.getMoney() * rankCnt;
            totalInput += LOTTO_PRICE * rankCnt;
        }
        Double yield = Double.valueOf(totalOutcome) / totalInput * 100;
        return Math.round(yield * 10) / 10.0;
    }

    public Map<Rank, Integer> returnInfo() {
        return result;
    }
}