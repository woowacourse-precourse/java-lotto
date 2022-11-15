package lotto;

public enum PrizeMoney {
    FIFTH(3, false, 5000, "5,000원"),
    FOURTH(4, false, 50000, "50,000원"),
    THIRD(5, false, 1500000, "1,500,000원"),
    SECOND(5, true, 30000000, "30,000,000원"),
    FIRST(6, false, 2000000000, "2,000,000,000원");
    private final int countEqual;
    private final Boolean isBonusNumberEqual;
    private final int prizeMoney;
    private final String prizeMoneyOutput;

    PrizeMoney(int countEqual, Boolean isBonusNumberEqual, int prizeMoney, String prizeMoneyOutput) {
        this.countEqual = countEqual;
        this.isBonusNumberEqual = isBonusNumberEqual;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyOutput = prizeMoneyOutput;
    }

    public int getCountEqual() {
        return countEqual;
    }

    public Boolean getBonusNumberEqual() {
        return isBonusNumberEqual;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMoneyOutput() {
        return prizeMoneyOutput;
    }
}
