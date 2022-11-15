package lotto;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    first(2000000000, 6, 0),
    second(30000000, 5, 1),
    third(1500000, 5, 0),
    fourth(50000, 4, 0),
    fifth(5000, 3, 0),
    nothing(0,-1,0);

    private final int prize, match, bonus;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void updateCount() {
        count++;
    }

    Rank(int prize, int match, int bonus) {
        this.prize = prize;
        this.match = match;
        this.bonus = bonus;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRank(int matchCount, int bonusCount) {
        return Arrays.stream(values())
                    .filter(rank -> rank.match == matchCount && rank.bonus == bonusCount)
                    .findFirst()
                    .orElse(nothing);
    }
}
