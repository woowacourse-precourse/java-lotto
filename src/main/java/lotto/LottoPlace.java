package lotto;

public enum LottoPlace {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchNumbers;
    private final int winMoney;

    LottoPlace(int matchNumbers, int winMoney) {
        this.matchNumbers = matchNumbers;
        this.winMoney = winMoney;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getWinMoney() {
        return winMoney;
    }
}
