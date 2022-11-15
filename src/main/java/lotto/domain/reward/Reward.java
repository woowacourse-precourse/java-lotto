package lotto.domain.reward;

public enum Reward {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    private int rank;
    private long money;

    Reward(int rank, long money) {
        this.rank = rank;
        this.money = money;
    }
}
