package lotto.domain;

import java.util.Arrays;

public enum Rating {
    FIRST(6, 2000000000, "2,000,000,000"),
    SECOND(5, 30000000, "30,000,000"),
    THIRD(5, 1500000, "1,500,000"),
    FOURTH(4, 50000, "50,000"),
    FIFTH(3, 5000, "5,000"),
    NONE(0, 0, "0");

    private final int count;
    private final int reward;
    private final String wrappingReward;

    Rating(final int count, final int reward, final String wrappingReward) {
        this.count = count;
        this.reward = reward;
        this.wrappingReward = wrappingReward;
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }

    public String getWrappingReward() {return wrappingReward; }

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
