package lotto.model;

public enum Prize {
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5_000, "5,000"),
    FOURTH(4, false, 50_000, "50,000"),
    THIRD(5, false, 1_500_000, "1,500,000"),
    SECOND(5, true, 30_000_000, "30,000,000"),
    FIRST(6, false, 2_000_000_000, "2,000,000,000")
    ;

    private final int lottoCount;
    private final boolean isBonus;
    private final int winningMoney;
    private final String winningMoneyString;

    Prize(int lottoCount, boolean isBonus, int winningMoney, String winningMoneyString) {
        this.lottoCount = lottoCount;
        this.isBonus = isBonus;
        this.winningMoney = winningMoney;
        this.winningMoneyString = winningMoneyString;
    }

    public static Prize get(int lottoCount, boolean isBonus) {
        if(lottoCount == 3){
            return FIFTH;
        } else if (lottoCount == 4) {
            return FOURTH;
        } else if (lottoCount == 5 && isBonus) {
            return SECOND;
        } else if (lottoCount == 5) {
            return THIRD;
        } else if (lottoCount == 6) {
            return FIRST;
        }

        return NONE;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public String getWinningMoneyString() {
        return winningMoneyString;
    }
}
