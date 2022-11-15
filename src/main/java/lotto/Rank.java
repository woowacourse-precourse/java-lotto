package lotto;

public enum Rank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private int money;

    Rank(int money) {
        this.money = money;
    }
}
