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
}
