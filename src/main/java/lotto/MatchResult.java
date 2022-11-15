package lotto;

public class MatchResult {
    private Integer countMatch;
    private Boolean bonusMatch;

    public MatchResult(Integer countMatch, Boolean bonusMatch) {
        this.countMatch = countMatch;
        this.bonusMatch = bonusMatch;
    }
}