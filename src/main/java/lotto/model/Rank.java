package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    MISS(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private final int winnings;
    private final int matchCount;

    Rank(int winnings, int matchCount) {
        this.winnings = winnings;
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Rank of(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(MISS);
    }

    public static List<Rank> get() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(MISS))
                .collect(Collectors.toList());
    }

    public boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }
}
