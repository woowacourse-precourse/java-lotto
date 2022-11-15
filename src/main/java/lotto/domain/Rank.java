package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000, 1),
    SECOND(7, 30000000, 2),
    THIRD(5, 1500000, 3),
    FOURTH(4, 50000, 4),
    FIFTH(3, 5000, 5),
    NOTHING(0, 0, 6);

    Rank(int count, int money, int rank) {
        this.count = count;
        this.rank = rank;
        this.money = money;
    }

    private final int count;
    private final int money;
    private final int rank;

    public static Rank checkRank(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank1 -> rank1.count == count)
                .findAny()
                .orElse(Rank.NOTHING);
    }

    public int getMoney() {
        return this.money;
    }

    public int getRank() {
        return this.rank;
    }
}
