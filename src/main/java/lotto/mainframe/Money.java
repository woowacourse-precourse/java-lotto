package lotto.mainframe;

public enum Money {

    FIRST_PRIZE("2,000,000,000원"),
    SECOND_PRIZE("30,000,000원"),
    THIRD_PRIZE("1,500,000원"),
    FOURTH_PRIZE("50,000원"),
    FIFTH_PRIZE("5,000원");

    public String money;

    Money(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}
