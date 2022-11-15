package lotto;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NONE(0);

    private final Integer prize;

    Rank(Integer prize) {
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }
}
