package lotto.domain;

public enum Rank {

    FIRST(6,2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private static final int FIRST_PRICE_NUM = 6;
    private static final int SECOND_PRICE_NUM = 5;
    private static final int THIRD_PRICE_NUM = 5;
    private static final int FOURTH_PRICE_NUM = 4;
    private static final int FIFTH_PRICE_NUM = 3;
=
    private final int prizemoney;

    Rank(int prizemoney) {
        this.prizemoney = prizemoney;
    }

    public static Rank of(int count, boolean bonus){
        if (count == FIRST_PRICE_NUM)
            return FIRST;
        if (bonus && count == SECOND_PRICE_NUM)
            return SECOND;
        if (count == THIRD_PRICE_NUM)
            return THIRD;
        if (count == FOURTH_PRICE_NUM)
            return FOURTH;
        if (count == FIFTH_PRICE_NUM)
            return FIFTH;
        return NOTHING;
    }

    public int getPrizemoney() {
        return prizemoney;
    }
}
