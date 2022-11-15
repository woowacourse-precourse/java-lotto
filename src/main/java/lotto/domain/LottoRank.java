package lotto.domain;

public enum LottoRank {
    FIFTH(3, 5000), FOURTH(4, 50000), THIRD(5, 1500000), SECOND(5, 30000000), FIRST(6, 2000000000);
    private final int winningPrice;
    private final int matchNormalCount;
    private int winningCount = 0;

    LottoRank(int matchNormalCount, int winningPrice) {
        this.matchNormalCount = matchNormalCount;
        this.winningPrice = winningPrice;
    }

    public void findMatchingRank(int normalCount) {
        if (this != THIRD && normalCount == this.matchNormalCount) {
            this.winningCount++;
        }
    }

    public boolean checkThirdPlace(int normalCount, int bonusCount) {
        if (this == THIRD && bonusCount == 0 && normalCount == this.matchNormalCount) {
            this.winningCount++;
            return true;
        }
        return false;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getNormalCount() {
        return matchNormalCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}