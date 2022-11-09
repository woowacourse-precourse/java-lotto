package lotto;

public enum Money {
    first("6개 일치 (2,000,000,000원) - "),
    second("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    third("5개 일치 (1,500,000원) - "),
    fourth("4개 일치 (50,000원) - "),
    fifth("3개 일치 (5,000원) - ");

    private final String money;

    Money(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}
