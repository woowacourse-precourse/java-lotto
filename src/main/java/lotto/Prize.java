package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST(1, 6, "6개 일치", 2000000000L),
    SECOND(2, 5, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(3, 5, "5개 일치", 1500000),
    FOURTH(4, 4, "4개 일치", 50000),
    FIFTH(5, 3, "3개 일치", 5000),
    INVALID(6, -1, "꽝", 0);

    private final int rank;
    private final int hit;
    private final String description;
    private final long cashPrize;

    Prize(int rank, int hit, String description, long cashPrize) {
        this.rank = rank;
        this.hit = hit;
        this.description = description;
        this.cashPrize = cashPrize;
    }

    public static Prize valueOfRank(int rank) {
        return Arrays.stream(values())
                .filter(v -> v.getRank() == rank)
                .findAny()
                .orElse(null);
    }

    public static Prize valueOfHit(int hit) {
        return Arrays.stream(values())
                .filter(v -> v.getHit() == hit)
                .findAny()
                .orElse(INVALID);
    }

    public int getRank() {
        return rank;
    }

    public int getHit() {
        return hit;
    }

    public String getDescription() {
        return description;
    }

    public long getCashPrize() {
        return cashPrize;
    }

}
