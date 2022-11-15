package lotto;

import java.util.Arrays;

public enum Ranking {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    FAILED(0, 0, false);

    private final int prize;
    private final int count;
    private final boolean isBonus;

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return isBonus;
    }

    Ranking(int prize, int count, boolean isBonus) {
        this.prize = prize;
        this.count = count;
        this.isBonus = isBonus;
    }

    public static Ranking getRanking(int count, boolean isBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == count && ranking.isBonus)
                .findAny()
                .orElse(FAILED);
    }

    public long mul(Integer count) {
        return (long) prize * count;
    }

}
