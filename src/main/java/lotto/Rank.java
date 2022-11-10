package lotto;

import java.util.Arrays;

public enum Rank {
    first(6, 2_000_000_000),
    second(7, 30_000_000),
    third(5, 1_500_000),
    fourth(4, 50_000),
    fifth(3, 5_000),
    fail(0,0);

    private final int numberCount;
    private final int prize;

    Rank(int numberCount, int prize) {
        this.numberCount = numberCount;
        this.prize = prize;


    }

    public static Rank getRank(final int numberCount) {
        if (numberCount < 3) {
            return fail;
        }

        return Arrays.stream(values()).filter(rank -> rank.numberCount == numberCount).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getPrize() {
        return prize;
    }

}
