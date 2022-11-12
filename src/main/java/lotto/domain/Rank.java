package lotto.domain;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4, false, 50000),
    FIFTH(3,false,5000);

    private final int cnt;
    private final boolean bonus;
    private final int reward;

    Rank(int cnt, boolean bonus, int reward) {
        this.cnt = cnt;
        this.bonus = bonus;
        this.reward = reward;
    }
}
