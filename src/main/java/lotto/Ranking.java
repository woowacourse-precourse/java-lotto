package lotto;

import java.util.Arrays;

public enum Ranking {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int count;
    private final boolean bonus;
    private final int prize;

    Ranking(int count, boolean bonus, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Ranking findRanking(int count, boolean bonus) {
        if (checkBonus(count, bonus)) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount(count))
                .findFirst()
                .orElse(NOTHING);
    }

    private static boolean checkBonus(int count, boolean bonus) {
        return count == 5 && bonus;
    }

    private boolean matchCount(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}
