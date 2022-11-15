package lotto.service;

import java.util.Arrays;
import java.util.Optional;

public enum Statistics {
    FIRST(0, 6, false, 2_000_000_000L),
    SEC(1, 5, true, 30_000_000L),
    THIRD(2, 5, false, 1_500_000L),
    FOURTH(3, 4, false, 50_000L),
    FIFTH(4, 3, false, 5_000L);

    private final int matchNums;
    private final boolean bonus;
    private final Long price;
    private final int index;

    public int getIndex() {
        return index;
    }

    public Long getPrice() {
        return price;
    }

    Statistics(int index, int matchNums, boolean bonus, Long price) {
        this.index = index;
        this.matchNums = matchNums;
        this.bonus = bonus;
        this.price = price;
    }

    public static Optional<Statistics> getRank(int num, boolean bonus) {
        return Arrays.stream(values())
                .filter(statistics -> statistics.matchNums == num && statistics.bonus == bonus)
                .findFirst();
    }
}
