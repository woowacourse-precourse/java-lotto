package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Ranking, Integer> result = new EnumMap<Ranking, Integer>(Ranking.class);

    public Result(List<Ranking> rankings) {
        makeWinningResult(rankings);
    }

    private void makeWinningResult(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
    }

    public long calculateTotalMoney() {
        List<Ranking> rankingList = Ranking.makeRankingList();
        long sum = 0;

        for (Ranking ranking : rankingList) {
            if (result.containsKey(ranking)) {
                int money = ranking.getMoney();
                int count = result.get(ranking);
                sum += Integer.valueOf(money * count);
            }
        }

        return sum;
    }

    public Map<Ranking, Integer> getResult() {
        return result;
    }
}
