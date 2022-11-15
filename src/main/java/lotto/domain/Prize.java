package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false),
    NOTHING(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean isBonus;

    Prize(int matchCount, int reward, boolean isBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.isBonus = isBonus;
    }

    public static Prize generatePrize(Result result) {
        return Arrays.stream(Prize.values())
                     .filter(result::isProperPrize)
                     .findFirst()
                     .orElse(NOTHING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
