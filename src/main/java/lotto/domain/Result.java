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
        List<Ranking> rankingResult = Ranking.makeRankingList();

        for (Ranking ranking : rankings) {
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        for (Ranking ranking : rankingResult) {
            if (!result.containsKey(ranking)) {
                result.put(ranking, 0);
            }
        }
    }

    public long calculateTotalMoney() {
        List<Ranking> rankingResult = Ranking.makeRankingList();
        long sum = 0;

        for (Ranking ranking : rankingResult) {
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
