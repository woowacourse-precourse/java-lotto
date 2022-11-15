package lotto;

public enum LottoRating {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NOTHING(0, 0, false);

    private final int prizeOfMatch;
    private final int winningMoney;
    private final boolean bonusNumber;

    LottoRating(int prizeOfMatch, int winningMoney, boolean bonusNumber) {
        this.prizeOfMatch = prizeOfMatch;
        this.winningMoney = winningMoney;
        this.bonusNumber = bonusNumber;
    }

    public int getPrizeOfMatch() {
        return prizeOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
