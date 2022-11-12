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

    public static Rank getRank(int match, boolean bonus) {
        if (match == 6) {
            return Rank.FIRST;
        } else if (match == 5) {
            if (bonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        } else if (match == 4) {
            return Rank.FOURTH;
        } else if (match == 3) {
            return Rank.FIFTH;
        }

        return Rank.LAST;
    }

    public int getPrize() {
        return this.prize;
    }
}