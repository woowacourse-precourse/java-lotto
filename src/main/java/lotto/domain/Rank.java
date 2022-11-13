package lotto.domain;

public enum Rank {
    ZERO(0,0,false),
    THREE(3, 5_000, false),
    FOUR(4,50_000,false),
    FIVE(5, 1_500_000,false),
    FIVEWITHBONUS(5,30_000_000, true),
    SIX(6,2_000_000_000, false);

    private int countOfMatch;
    private int reward;
    private boolean isMatchedBonus;

    Rank(int countOfMatch, int reward, boolean isMatchedBonus) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
        this.isMatchedBonus = isMatchedBonus;
    }
}
