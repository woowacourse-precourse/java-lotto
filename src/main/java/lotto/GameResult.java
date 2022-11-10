package lotto;

import java.util.Arrays;

public enum GameResult {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int sameNumberCount;
    private final int winnerPrice;
    private final boolean isSameBonus;

    GameResult(int sameNumberCount, int winnerPrice, boolean isSameBonus) {
        this.sameNumberCount = sameNumberCount;
        this.winnerPrice = winnerPrice;
        this.isSameBonus = isSameBonus;
    }

    public static GameResult of(int sameNumberCount) {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> gameResult.isEqualSameCount(sameNumberCount))
                .findFirst()
                .orElseThrow();
    }

    private boolean isEqualSameCount(int sameCount) {
        return this.sameNumberCount == sameCount;
    }

    public boolean isFirst() {
        return this == FIRST;
    }
}
