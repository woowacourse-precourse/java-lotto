package lotto.model;

public class MatchedResult {
    private int matchedNum;
    private boolean bonusMatched;

    MatchedResult(int matchedNum, boolean bonusMatched) {
        this.bonusMatched = bonusMatched;
        this.matchedNum = matchedNum;
    }

    public int getMatchedNum() {
        return matchedNum;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }
}