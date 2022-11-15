package lotto;

import java.util.ArrayList;
import java.util.List;

public enum WinningRanking {
    FIRST_WITHOUT_BONUS(1,6,0, 2_000_000_000),
    FIRST_WITH_BONUS(1,6,1, 2_000_000_000),
    SECOND(2,5,1, 30_000_000),
    THIRD_WITHOUT_BONUS(3,5,0, 1_500_000),
    THIRD_WITH_BONUS(3,5,1, 1_500_000),
    FOURTH_WITHOUT_BONUS(4,4,0, 50_000),
    FOURTH_WITH_BONUS(4,4,1, 50_000),
    FIFTH_WITHOUT_BONUS(5,3,0, 5_000),
    FIFTH_WITH_BONUS(5,3,1, 5_000);

    private final int order;
    private final int countMatches;
    private final int isMatchBonus;
    private final int prize;
    WinningRanking(int order, int countMatches, int isMatchBonus, int prize){
        this.order=order;
        this.countMatches=countMatches;
        this.isMatchBonus=isMatchBonus;
        this.prize=prize;
    }
    public List<Integer> getRanking(){
        return new ArrayList<>(List.of(countMatches, isMatchBonus));
    }
    public int getOrder(){
        return order;
    }
    public int getCountMatches(){
        return countMatches;
    }
    public int getIsMatchBonus(){
        return isMatchBonus;
    }
    public int getPrize(){
        return prize;
    }
}
