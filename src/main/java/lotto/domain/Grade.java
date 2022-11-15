package lotto.domain;

public enum Grade {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5 + 10, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int money;

    Grade(int count, int money) {
        this.count = count;
        this.money = money;
    }

    int getCount() {
        return count;
    }

    int getMoney(){
        return money;
    }
}


