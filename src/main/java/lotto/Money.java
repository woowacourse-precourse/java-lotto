package lotto;

public enum Money {
    first("6개 일치 (2,000,000,000원) - ", 2000000000),
    second("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    third("5개 일치 (1,500,000원) - ", 1500000),
    fourth("4개 일치 (50,000원) - ", 50000),
    fifth("3개 일치 (5,000원) - ", 5000),
    notThing("", 0);

    private final String moneyString;
    private final int money;

    Money(String moneyString, int money) {
        this.moneyString = moneyString;
        this.money = money;
    }

    public String getMoneyString() {
        return moneyString;
    }

    public int getMoney() {
        return money;
    }
}
