package lotto;

public enum LottoRating {
    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);


    private final int prizeOfMatch;
    private final int winningMoney;

    LottoRating(int prizeOfMatch, int winningMoney) {
        this.prizeOfMatch = prizeOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getPrizeOfMatch() {
        return prizeOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
