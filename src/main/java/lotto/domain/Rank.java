package lotto.domain;

public enum Rank {
    THREE(3, 5_000, "3개 일치 (5,000원) - "),
    FOUR(4, 50_000, "4개 일치 (50,000원) - "),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FIVE_WITH_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final int reward;
    private final String winningMessage;

    Rank(final int matchCount, final int reward, final String winningMessage) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.winningMessage = winningMessage;
    }

    public int getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return this.winningMessage;
    }
}
