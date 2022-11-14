package constants;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRank(int numberOfMatch) {
        return Arrays.stream(Rank.values())
                .filter(Rank -> Rank.matchCount == numberOfMatch)
                .findFirst()
                .orElse(null);
    }
}
