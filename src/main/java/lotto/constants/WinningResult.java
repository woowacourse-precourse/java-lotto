package lotto.constants;

public enum WinningResult {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private final int prize;

    WinningResult(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
