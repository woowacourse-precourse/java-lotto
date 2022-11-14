package domain;

import java.util.Map;

public class Reward {

    public Long totalReward(Map<Rank, Integer> map){
        Long sum = 0L;
        for(Rank rank : map.keySet()){
            sum += map.get(rank) * rank.getReward();
        }
        return sum;
    }

    public double percentage(Long sum, int money){
        double percent = Math.round((sum / (double) money)*10) / 10.0;
        return percent;
    }
}
