package lotto.domain.enummodel;

public enum RankEnum {

    FIRST(7, 2_000_000_000),
    SECOND(6, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4,50_000),
    FIFTH(3, 5_000);
    private final int matchNumber;
    private final int winnings;


    RankEnum(int matchNumber, int winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getWinnings() {
        return winnings;
    }
}

