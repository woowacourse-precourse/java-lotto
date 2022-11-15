package lotto;

public enum Money {
    LUCKY_3(5000),
    LUCKY_4(50000),
    LUCKY_5(1500000),
    LUCKY_5_BONUS(30000000),
    LUCKY_6(2000000000);

    final private Integer money;

    Money(int money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }
}
