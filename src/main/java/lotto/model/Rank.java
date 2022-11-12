package lotto.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public enum Rank {
    NONE(0),
    FIRST_PLACE(6),
    SECOND_PLACE(5),
    THIRD_PLACE(5),
    FOURTH_PLACE(4),
    FIFTH_PLACE(3);

    private int count;

    Rank(int count) {
        this.count = count;
    }


    private static Rank find(Predicate<Rank> predicate) {
        return Arrays.stream(values())
                .filter(predicate)
                .findAny()
                .orElse(NONE);
    }

    public static Rank findRankWithcount(int count) {
        return find(e -> Objects.equals(e.count, count));
    }

    public static int findcountWithRank(Rank rank) {
        return rank.count;
    }
}
