package lotto.enums;

import java.util.Arrays;

public enum WinningResult {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSER(0, false, 0);

    private final int matchCount;
    private final boolean haveBonus;
    private final int reward;

    WinningResult(int matchCount, boolean haveBonus, int reward) {
        this.matchCount = matchCount;
        this.haveBonus = haveBonus;
        this.reward = reward;
    }

    public static WinningResult findByMatchCountAndBonus(int matchCount, boolean haveBonus) {
        return Arrays.stream(values())
                .filter(e -> e.matchCount == matchCount && e.haveBonus == haveBonus)
                .findFirst()
                .orElse(LOSER);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHaveBonus() {
        return haveBonus;
    }

    public int getReward() {
        return reward;
    }
}
