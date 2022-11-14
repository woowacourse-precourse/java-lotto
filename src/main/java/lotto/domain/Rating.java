package lotto.domain;

import java.util.Arrays;

public enum Rating {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int count;
    private final int reward;

    Rating(final int count, final int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }

    public static Rating getRating(final int count, final boolean bonusCount) {
        if(count == THIRD.count && !bonusCount) {
            return THIRD;
        }

        if(count < FIFTH.count) {
            return NONE;
        }

        return Arrays.stream(Rating.values())
                .filter(rating -> count == rating.count)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
