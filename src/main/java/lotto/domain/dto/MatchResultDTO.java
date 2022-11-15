package lotto.domain.dto;

public class MatchResultDTO {

    private final int matchCount;
    private final boolean isMatchBonus;

    public MatchResultDTO(int matchCount, boolean isMatchBonusNumber) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonusNumber;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean isMatchBonus() {
        return this.isMatchBonus;
    }

}
