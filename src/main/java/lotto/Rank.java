package lotto;

import java.util.List;

public enum Rank {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND( 30_000_000),
    FIRST(2_000_000_000),
    LAST(0);

    private final int prize;

    private Rank(int prize) {
        this.prize = prize;
    }
    

    public int getPrize() {
        return this.prize;
    }
}