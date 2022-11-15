package lotto;

public enum LottoRanking {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private final int prize;

    LottoRanking(int prize) {
        this.prize = prize;
    }
    public int prize() {
        return prize;
    }
}
