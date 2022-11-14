package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST(1, "6개 일치", 2000000000000L),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(3, "5개 일치", 1500000),
    FOURTH(4, "4개 일치", 50000),
    FIFTH(5, "3개 일치", 5000);

    private final int rank;
    private final String description;
    private final long cashPrize;

    Prize(int rank, String description, long cashPrize) {
        this.rank = rank;
        this.description = description;
        this.cashPrize = cashPrize;
    }

    public static Prize valueOfRank(int rank){
        return Arrays.stream(values())
                .filter(v -> v.getRank() == rank)
                .findAny()
                .orElse(null);
    }

    public int getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public long getCashPrize() {
        return cashPrize;
    }

}
