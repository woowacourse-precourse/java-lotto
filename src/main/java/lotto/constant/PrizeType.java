package lotto.constant;

public enum PrizeType {
    FIVE_THOUSAND("5,000"),
    FIFTY_THOUSAND("50,000"),
    ONE_AND_A_HALF_MILLION("1,500,000"),
    THIRTY_MILLION("30,000,000"),
    TWO_BILLION("2,000,000,000"),
    NONE("0");

    private final String money;

    PrizeType(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}
