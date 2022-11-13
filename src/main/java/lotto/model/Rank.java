package lotto.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public enum Rank {
    NONE(0, 0),
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000);

    private int count;
    private int reward;

    Rank(int count,
         int reward
    ) {
        this.count = count;
        this.reward = reward;
    }


    private static Rank find(Predicate<Rank> predicate) {
        return Arrays.stream(values())
                .filter(predicate)
                .findAny()
                .orElse(NONE);
    }

    public static Rank findRankWithCount(int count) {
        return find(e -> Objects.equals(e.count, count));
    }

    public static int findCountWithRank(Rank rank) {
        return rank.count;
    }

    public static int findRewardWithRank(Rank rank) {
        return rank.reward;
    }
}
