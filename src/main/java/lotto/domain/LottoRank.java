package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final int winningCount;
    private final boolean bonusNumberCount;
    private final long reward;

    LottoRank(int winningCount, boolean bonusNumberCount, long reward) {
        this.winningCount = winningCount;
        this.bonusNumberCount = bonusNumberCount;
        this.reward = reward;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public long getReward() {
        return reward;
    }

    public static LottoRank getLottoRank(int winningNumberCount, boolean bonusNumberCount) {
        final boolean finalWinningCountIsFiveCheckResult = winningCountIsFiveCheck(winningNumberCount, bonusNumberCount);
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchWinningCount(winningNumberCount) && lottoRank.bonusNumberCount(finalWinningCountIsFiveCheckResult))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private static boolean winningCountIsFiveCheck(int winningCount, boolean bonusNumberCount) {
        boolean winningCountIsFive = bonusNumberCount;
        if (winningCount != 5) {
            winningCountIsFive = false;
        }
        return winningCountIsFive;
    }

    private boolean matchWinningCount(int winningCount) {
        return this.winningCount == winningCount;
    }

    private boolean bonusNumberCount(boolean bonusNumberCount) {
        return this.bonusNumberCount == bonusNumberCount;
    }
}
