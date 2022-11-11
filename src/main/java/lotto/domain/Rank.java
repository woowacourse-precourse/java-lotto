package lotto.domain;

public enum Rank {

    FIRST(6,2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int count;
    private final int prizemoney;

    Rank(int count, int prizemoney) {
        this.count = count;
        this.prizemoney = prizemoney;
    }

    public static Rank of(int count, boolean bonus){
        if (count == FIRST.count)
            return FIRST;
        if (bonus && count == SECOND.count)
            return SECOND;
        if (count == THIRD.count)
            return THIRD;
        if (count == FOURTH.count)
            return FOURTH;
        if (count == FIFTH.count)
            return FIFTH;
        return NOTHING;
    }

    public int getPrizemoney() {
        return prizemoney;
    }
}
