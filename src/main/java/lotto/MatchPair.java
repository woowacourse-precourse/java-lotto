package lotto;

public class MatchPair {
    private final int matchNumbers;
    private final boolean matchBonusNumber;

    public MatchPair(int matchNumbers, boolean matchBonusNumber) {
        this.matchNumbers = matchNumbers;
        this.matchBonusNumber = matchBonusNumber;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int calculateRanking() {
        if (this.matchNumbers == 6) {
            return 1;
        }
        if (this.matchNumbers == 5 && this.matchBonusNumber) {
            return 2;
        }
        if (this.matchNumbers <= 5 && this.matchNumbers >= 3) {
            return (8 - this.matchNumbers);
        }
        return 0;
    }
}
