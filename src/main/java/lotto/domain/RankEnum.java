package lotto.domain;

public enum RankEnum {

    FIRST(6, 2_000_000_000, true),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4,50_000, false),
    FIFTH(3, 5_000, false);
    private final int matchNumber;
    private final int winnings;
    private final Boolean bonus;


    RankEnum(int matchNumber, int winnings, Boolean bonus) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
        this.bonus = bonus;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getWinnings() {
        return winnings;
    }

    public Boolean getBonus() {
        return bonus;
    }
}

