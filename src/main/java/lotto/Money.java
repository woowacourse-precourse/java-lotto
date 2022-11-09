package lotto;

public enum Money {
    first("(2,000,000,000원)"),
    second("(30,000,000원)"),
    third("(1,500,000원)"),
    fourth("(50,000원)"),
    fifth("(5,000원)");

    private final String money;

    Money(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}
