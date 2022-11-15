package lotto;

import java.util.Arrays;

public enum Numbers {
    NOTHING(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int count;

    Numbers(int count) {
        this.count = count;
    }

    public static Numbers findRank(int count) {
        return Arrays.stream(values())
                .filter(rank ->  rank.match(count))
                .findFirst()
                .orElse(NOTHING);
    }

    public boolean match(int count) {
        return this.count == count;
    }
}
