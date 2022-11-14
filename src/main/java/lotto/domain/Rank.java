package lotto.domain;

import java.util.Arrays;

public enum Rank {
    LOSE(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Rank get(int matchCount, boolean bonus) {
        if (matchCount == 5 && bonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }

    public int getPrize() {
        return prize;
    }
}
