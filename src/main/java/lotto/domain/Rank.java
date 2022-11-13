package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    ZERO(-1, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    FIVE_ALPHA(7, 30_000_000);

    private int count;
    private int money;


    Rank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Rank findMoney(int count) {
        return Stream.of(values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(ZERO);
    }
}
