package lotto;

public class MatchDto {
    private int matchCount;
    private boolean bonusState;

    private MatchDto(int matchCount, boolean bonusState) {
        this.matchCount = matchCount;
        this.bonusState = bonusState;
    }

    public static MatchDto of(int matchCount, boolean bonusState){
        return new MatchDto(matchCount, bonusState);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusState() {
        return bonusState;
    }
}
