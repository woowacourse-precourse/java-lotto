package lotto;

import java.util.Arrays;

public enum Rank {
    WIN_SIX(6, 2_000_000_000, "6개 일치"),
    WIN_FIVE_WITH_BONUS5(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    WIN_FIVE(5, 1_500_000, "5개 일치"),
    WIN_FOUR(4, 50_000, "4개 일치"),
    WIN_THREE(3, 5_000, "3개 일치"),
    MISS(0, 0, "3개 미만 일치");

    private final int count;
    private final int winningReward;
    private final String status;

    Rank(final int matchCount, final int winningReward, final String status) {
        this.count = matchCount;
        this.winningReward = winningReward;
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public int getWinningReward() {
        return winningReward;
    }

    public String getStatus() {
        return status;
    }

}
