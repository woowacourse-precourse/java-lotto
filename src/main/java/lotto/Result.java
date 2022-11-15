package lotto;

import java.util.Map;

public class Result {
    private final Map<Ranking,Integer> result;

    public Result(Map<Ranking, Integer> result) {
        this.result = result;
    }

    public double profitRate(UserMoney money){
        long totalReward = result.entrySet()
                .stream()
                .mapToLong(this::reward)
                .sum();

        return (double) (totalReward*100) / (double) money.getUserMoney();
    }

    private long reward(Map.Entry<Ranking,Integer> ranking){
        return ranking.getKey().getReward()*ranking.getValue();
    }
}
