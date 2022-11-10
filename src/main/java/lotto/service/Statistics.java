package lotto.service;

import java.util.Arrays;
import java.util.Optional;

public enum Statistics {
    FIRST(6, false, 2_000_000_000),
    SEC(5, true,30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),;

    private final int matchNums;
    private final boolean bonus;
    private final int price;

    private Statistics(int matchNums, boolean bonus, int price) {
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
