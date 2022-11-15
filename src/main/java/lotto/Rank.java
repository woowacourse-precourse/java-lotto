package lotto;

import java.util.Arrays;

public enum Rank {
    first(6, 2_000_000_000, 0),
    second(7, 30_000_000, 0),
    third(5, 1_500_000, 0),
    fourth(4, 50_000, 0),
    fifth(3, 5_000, 0),
    fail(0,0, 0);

    private final int numberCount;
    private final int prize;
    private int winCount;

    Rank(int numberCount, int prize, int winCount) {
        this.numberCount = numberCount;
        this.prize = prize;
        this.winCount = winCount;

    }

    public static Rank getRank(final int numberCount) {
        if (numberCount < 3) {
            return fail;
        }

        return Arrays.stream(values()).filter(rank -> rank.numberCount == numberCount).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public void rankCounting(Rank rank) {
        rank.winCount++;
    }


    public int getWinCount() {
        return winCount;
    }

    public int getPrize() {
        return prize;
    }

}
