package lotto.service;

import java.util.Arrays;
import java.util.Optional;

public enum Statistics {
    FIRST(6, false, 2_000_000_000L),
    SEC(5, true,30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),;

    private final int matchNums;
    private final boolean bonus;
    private final Long price;

    Statistics(int matchNums, boolean bonus, Long price) {
        this.matchNums = matchNums;
        this.bonus = bonus;
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public static Optional<Statistics> getRank(int num, boolean bonus) {
        return Arrays.stream(values())
                .filter(statistics -> statistics.matchNums == num && statistics.bonus == bonus)
                .findFirst();
    }
}
