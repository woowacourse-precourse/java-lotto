package lotto.enums;

public enum RankPrize {
    FIRST_PRIZE(1), SECOND_PRIZE(2), THIRD_PRIZE(3), FOURTH_PRIZE(4), FIFTH_PRIZE(5);

    private int rank;

    RankPrize(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
