package lotto.enums;

import java.util.Arrays;

public enum Rank {
    FIRST(6,false,  2000000000),
    SECOND(5,true, 30000000),
    THIRD(5,false,  1500000),
    FOURTH(4,false,  50000),
    FIFTH(3,false,  5000),
    NONE(0,false,0);

    private final int count;
    private final boolean bonus;
    private final int prize;

    Rank(int count, boolean bonus, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Rank findRank(int count, boolean bonus) {
        if (count == 5 && bonus) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count && rank.bonus == false)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }
}
