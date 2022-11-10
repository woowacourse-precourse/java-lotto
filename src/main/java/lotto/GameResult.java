package lotto;

import java.util.Arrays;

public enum GameResult {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    ELSE(0, 0, false);

    private final int sameNumberCount;
    private final int winnerPrice;
    private final boolean isSameBonus;

    GameResult(int sameNumberCount, int winnerPrice, boolean isSameBonus) {
        this.sameNumberCount = sameNumberCount;
        this.winnerPrice = winnerPrice;
        this.isSameBonus = isSameBonus;
    }

    public static GameResult of(int sameNumberCount, boolean isSameBonus) {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> gameResult.isEqualSameNumberCount(sameNumberCount))
                .filter(gameResult -> gameResult.isEqualSameBonus(isSameBonus))
                .findFirst()
                .orElse(ELSE);
    }

    private boolean isEqualSameNumberCount(int sameCount) {
        return this.sameNumberCount == sameCount;
    }

    private boolean isEqualSameBonus(boolean isSameBonus) {
        return this.isSameBonus == isSameBonus;
    }

    public boolean isFirst() {
        return this == FIRST;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public boolean isFourth() {
        return this == FOURTH;
    }
}
