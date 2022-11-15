package lotto.constant;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5000),
    NOT_WINNING(0, 0);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }
    public static Rank judgeRank(int matchCount, boolean containBonus){
        if(matchCount == THIRD_PLACE.matchCount && !containBonus) {
            return THIRD_PLACE;
        }
        for(Rank value: Rank.values()){
            if(value.matchCount == matchCount){
                return value;
            }
        }
        return NOT_WINNING;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
