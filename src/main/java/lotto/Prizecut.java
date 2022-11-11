package lotto;

public enum Prizecut {

    FIRST("2,000,000,000원"),
    SECOND("30,000,000원"),
    THIRD("1,500,000원"),
    FOURTH("50,000원"),
    FIFTH("5,000원");

    private final String prizeMoney;

    Prizecut(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
