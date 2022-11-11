package lotto;

public enum Place {
    LOSE("0"),
    FIRST("2,000,000,000"),
    SECOND("30,000,000"),
    THIRD("1,500,000"),
    FOURTH("50,000"),
    FIFTH("5,000");

    private String prizeMoney;

    Place(String amount) {
        this.prizeMoney = amount;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
