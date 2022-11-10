package lotto.domain;

public enum Result {
    NONE(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);

    private int prize;
    Result(int prize) {
        this.prize = prize;
    }
}
