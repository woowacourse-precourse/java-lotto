package lotto;

import java.util.Map;

public class Result {
    private final Map<Ranking,Integer> result;

    public Result(Map<Ranking, Integer> result) {
        this.result = result;
    }

    public double profitRate(){

    }

    private long reward(Map.Entry<Ranking,Integer> ranking){
        return ranking.getKey().getReward()*ranking.getValue();
    }
}
