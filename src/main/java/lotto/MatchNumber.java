package lotto;

enum MatchNumber {
    Zero(0,0,6),
    THREE(3, 5000,5),
    FOUR(4, 50000,4),
    FIVE(5, 1500000,3),
    FIVE_BONUS(5, 30000000,2),
    SIX(6, 2000000000,1);

    private final int value;
    private final int prize;
    private final int rank;

    MatchNumber(int value, int prize, int rank) {
        this.value = value;
        this.prize = prize;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }
}
