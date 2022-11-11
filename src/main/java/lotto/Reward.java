package lotto;

public enum Reward {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    ;

    private int amount;
    private Reward(int amount) {
        this.amount = amount;

    }
}
