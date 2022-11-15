package lotto.domain;

import java.util.Arrays;

public enum WinningType {
    NONE(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int equalCount;
    private final int winnings;
    private final boolean withBonus;

    WinningType(int equalCount, int winnings, boolean withBonus) {
        this.equalCount = equalCount;
        this.winnings = winnings;
        this.withBonus = withBonus;
    }

    public static WinningType getWinningType(int equalCount, boolean withBonus) {
        return Arrays.stream(WinningType.values())
                .filter(type -> (type.equalCount == equalCount && type.withBonus == withBonus))
                .findAny()
                .orElse(NONE);
    }

    public int getEqualCount() {
        return equalCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public boolean getWithBonus() {
        return withBonus;
    }

}
