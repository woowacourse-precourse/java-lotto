package lotto.domain;

public enum Rank {
    FIRST(0, 2000000000),
    SECOND(0, 30000000),
    THIRD(0, 1500000),
    FOURTH(0, 50000),
    FIFTH(0, 5000);

    private int count;
    private final int money;

    Rank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public void plusCount() {
        count++;
    }

}
