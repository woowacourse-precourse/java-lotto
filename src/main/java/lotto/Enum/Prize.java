package lotto.Enum;

public enum Prize {

    FIRST_PRIZE(2000000000, 6),
    SECOND_PRIZE(30000000, 5),
    THIRD_PRIZE(1500000, 5),
    FOURTH_PRIZE(50000, 4),
    FIFTH_PRIZE(5000, 3);
    private final int prize;
    private final int contained;
    Prize(int prize, int contained) {
        this.prize = prize;
        this.contained = contained;
    }
    public int getPrize() {
        return prize;
    }
    public int getContained() {
        return contained;
    }
}
