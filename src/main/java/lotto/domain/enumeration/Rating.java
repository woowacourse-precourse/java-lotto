package lotto.domain.enumeration;

public enum Rating {
    FIRST(6,2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    NONE(0,0);

    private final int accord;
    private final int prize;

    Rating(int accord, int prize) {
        this.accord = accord;
        this.prize = prize;
    }

    public int getAccord() {
        return accord;
    }

    public int getPrize() {
        return prize;
    }
}
