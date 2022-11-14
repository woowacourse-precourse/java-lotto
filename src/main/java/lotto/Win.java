package lotto;

public enum Win {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int sameNumberCnt;
    private final int prize;

    Win(int sameNumberCnt, int prize) {
        this.sameNumberCnt = sameNumberCnt;
        this.prize = prize;
    }

    public int sameNumberCnt() {
        return sameNumberCnt;
    }

    public int prize() {
        return prize;
    }
}
