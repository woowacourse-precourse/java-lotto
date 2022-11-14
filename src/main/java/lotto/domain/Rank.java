package lotto.domain;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4, false, 50000),
    FIFTH(3,false,5000),
    NONE(0,false,0);

    private final int cnt;
    private final boolean bonus;
    private final int reward;

    Rank(int cnt, boolean bonus, int reward) {
        this.cnt = cnt;
        this.bonus = bonus;
        this.reward = reward;
    }

    public Rank findRank(int cnt, boolean bonus) {
        if (FIRST.cnt == cnt) {
            return FIRST;
        }
        if (SECOND.cnt == cnt) {
            if (bonus == true) {
                return SECOND;
            }
            return THIRD;
        }
        if (FOURTH.cnt == cnt) {
            return FOURTH;
        }
        if (FIFTH.cnt == cnt) {
            return FIFTH;
        }
        return NONE;
    }
}
