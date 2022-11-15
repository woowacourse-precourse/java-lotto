package lotto.domain;

import java.util.Arrays;

public enum Rank {
    LOSE(0, "0원", 0),
    FIFTH(5000, "(5,000원)", 3),
    FOURTH(50000, "(50,000원)", 4),
    THIRD(1500000, "(1,500,000원)", 5),
    SECOND(30000000, "(30,000,000원)", 5),
    FIRST(2000000000, "(2,000,000,000원)", 6);

    private final int prize;
    private final String prizeForPrint;
    private final int matchCount;

    Rank(int prize, String prizeForPrint, int matchCount) {
        this.prize = prize;
        this.prizeForPrint = prizeForPrint;
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

    public int getMatchCount() {
        return matchCount;
    }

    public String getPrizeForPrint() {
        return prizeForPrint;
    }
}
