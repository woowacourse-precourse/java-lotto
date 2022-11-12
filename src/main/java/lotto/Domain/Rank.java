package lotto.Domain;

import lotto.type.RankType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Rank {
    private float earningRate;
    private Map<RankType, Integer> rank = new EnumMap<RankType, Integer>(RankType.class);

    public void setEarningRate(int money) {
        int total = 0;
        for(RankType rankType: rank.keySet()) {
            if(rank.get(rankType) > 0) {
                total += rankType.getPrizeMoney();
            }
        }
        this.earningRate = total / (float)money * 100;
    }
    public float getEarningRate() {
        return this.earningRate;
    }

    public Map<RankType, Integer> getRank() {
        return this.rank;
    }

    public void setRank(RankType rankType) {
        this.rank.put(rankType, rank.getOrDefault(rankType, 0) + 1);
    }

    public int countWinningNumber(List<Integer> lotto, List<Integer> playerLotto) {
        return (int) lotto.stream()
                .filter(playerLotto::contains)
                .count();
    }

    public boolean isBonusBallContain(List<Integer> lotto, int bonusBall) {
        return lotto.contains(bonusBall);
    }
}
