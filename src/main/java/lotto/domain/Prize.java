package lotto.domain;

public enum Prize {
    FIFTH_PRIZE(3, 5000),
    FORTH_PRIZE(4, 50000),
    THIRD_PRIZE(5, 1500000),
    SECOND_PRIZE(7, 30000000),
    FIRST_PRIZE(6, 2000000000);

    public int sameNumbers;
    public int money;

    Prize(int sameNumbers, int money) {
        this.sameNumbers = sameNumbers;
        this.money = money;
    }

    public int getSameNumbers() {
        return sameNumbers;
    }
}
