package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum Rank {
    BANG(0, 0),
    FIVE(3, 5_000),
    FOUR(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private  int count;
    private int reward;
    private static Map<Rank,Integer> rankCount = new EnumMap<Rank, Integer>(Rank.class);
    Rank(final int count, final int reward) {
        this.count = count;
        this.reward = reward;
    }

    public static Rank countCondition(final int count ,final boolean bonus) {
        if(count == 5 && bonus){
            return SECOND;
        }
        if(count<3){
            return BANG;
        }

        return Arrays.stream(Rank.values()).filter(rank -> rank.count == count).findAny().orElseThrow();
    }

    public static void settingRankMap() {
        for(Rank rank : Rank.values()){
            rankCount.put(rank,0);
        }
    }
    public static void addRankCount(Rank rank){
        rankCount.put(rank, rankCount.getOrDefault(rank,0)+1);
    }

    public static Map<Rank,Integer> getRankCount(){
        return rankCount;
    }

    public int getReward(){
        return reward;
    }

}
