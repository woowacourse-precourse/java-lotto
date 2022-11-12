package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Result {

    private Map<Rank, Integer> rankInfo;
    private float winningAmount;

    public Result() {
        rankInfo = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankInfo.put(rank, 0));
    }

    public void initWinningAmount(int purchase){
        for (Rank rank : rankInfo.keySet()) {
            winningAmount += rank.getPrize() * rankInfo.get(rank);
        }
        winningAmount = (winningAmount / purchase) * 100;
    }

    public void updateRankInfo(Rank rank) {
        rankInfo.put(rank, rankInfo.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankInfo() {
        return rankInfo;
    }

    public int getRankCount(Rank rank) {
        return rankInfo.get(rank);
    }

    public float getWinningAmount() {
        return winningAmount;
    }
}
