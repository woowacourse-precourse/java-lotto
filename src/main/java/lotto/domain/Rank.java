package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    BANG(0, 0, false);
    private static final int SECOND_THIRD_COUNT = 5;

    private final int count;
    private final int winningPrice;
    private final boolean hasBonusBall;

    Rank(int count, int winningPrice, boolean hasBonusBall) {
        this.count = count;
        this.winningPrice = winningPrice;
        this.hasBonusBall = hasBonusBall;
    }

    public static Rank rankDetermine(int count, boolean hasBonusBall){
        if (count == SECOND_THIRD_COUNT && hasBonusBall){
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.count == count)
                .filter(rank -> !rank.hasBonusBall)
                .findFirst()
                .orElse(BANG);
    }
    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }
}
