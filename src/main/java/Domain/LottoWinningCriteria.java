package Domain;

public enum LottoWinningCriteria {
    FIFTH_PLACE(3, 5000, 0),
    FOURTH_PLACE(4, 50000, 0),
    THIRD_PLACE(5, 1500000, 0),
    SECOND_PLACE(5, 30000000, 0),
    FIRST_PLACE(6, 200000000, 0);

    private int match;
    private int winnerMoney;
    private int count;

    LottoWinningCriteria(int match, int winnerMoney, int count) {
        this.match = match;
        this.winnerMoney = winnerMoney;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getWinMoney() {
        return winnerMoney;
    }
}
