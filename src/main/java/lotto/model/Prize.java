package lotto.model;

import lotto.enums.Rank;

import java.util.List;
import java.util.Map;

public class Prize {
    private long prize = 0;
    public Prize(Map<Rank, Integer> ranking) {
        setPrize(ranking);
    }
    private void setPrize(Map<Rank, Integer> ranking) {
        for(Rank rank: Rank.values()) {
            prize += caculatePrize(rank.getRank().get(1), ranking.get(rank));
        }
    }
    private long caculatePrize(int money, int count) {
        return (long) money *count;
    }
    public long getPrize() {
        return prize;
    }
}
