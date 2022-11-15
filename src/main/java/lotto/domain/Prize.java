package lotto.domain;

public enum Prize {
    FIRST_PLACE(6, 2000000000, "2,000,000,000"),
    SECOND_PLACE(5, 30000000, "30,000,000", true),
    THIRD_PLACE(5, 1500000, "1,500,000"),
    FOURTH_PLACE(4, 50000, "50,000"),
    FIFTH_PLACE(3, 5000, "5,000");

    private final int match;
    private final int money;
    private final String stringMoney;
    private final boolean bonus;

    Prize(int match, int money, String stringMoney) {
        this.match = match;
        this.money = money;
        this.stringMoney = stringMoney;
        this.bonus = false;
    }

    Prize(int match, int money, String stringMoney, boolean bonus) {
        this.match = match;
        this.money = money;
        this.stringMoney = stringMoney;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public String getStringMoney() {
        return stringMoney;
    }

    public boolean isBonus() {
        return bonus;
    }
}
