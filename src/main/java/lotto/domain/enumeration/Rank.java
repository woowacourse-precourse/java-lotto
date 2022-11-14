package lotto.domain.enumeration;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
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

    public static Rank of(int count, boolean bonus) {
        if (bonus && count == SECOND.count) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .filter(value -> value != Rank.SECOND)
                .findAny()
                .orElse(NOTHING);
    }

    public int getPrizemoney() {
        return prizemoney;
    }
}
