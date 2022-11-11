package lotto.domain;

public enum Rank {
    ONE(6, 0, 2000000000, "2,000,000,000원"),
    TWO(5, 1, 30000000, "30,000,000원"),
    THREE(5, 0, 1500000, "1,500,000원"),
    FOUR(4, 0, 50000, "50,000원"),
    FIVE(3, 0, 5000, "5,000원"),
    LOSE(0, 0, 0, "0원");
    private int compare;
    private int bonus;
    private int money;
    private String moneyWon;

    Rank(int compare, int bonus, int money, String moneyWon) {
        this.compare = compare;
        this.bonus = bonus;
        this.money = money;
        this.moneyWon = moneyWon;
    }

    public int getCompare() {
        return this.compare;
    }

    public int getBonus() {
        return bonus;
    }

    public int getMoney() {
        return money;
    }

    public String getMoneyWon() {
        return moneyWon;
    }
}
