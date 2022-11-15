package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5.5f, 30_000_000),
    ALL_MATCH(6, 2_000_000_000);

    private final float matching;
    private final long prize;

    Rank(float matching, long prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public static long getPrize(float matching) {
        return Arrays.stream(values())
                .filter(rank -> rank.matching == matching)
                .findFirst()
                .get().prize;
    }

    public static List<Float> getNumbersOfMatching() {
        List<Float> numbersOfMatching = new ArrayList<>();

        Arrays.stream(values())
                .forEach(rank -> numbersOfMatching.add(rank.matching));

        return numbersOfMatching;
    }
}
