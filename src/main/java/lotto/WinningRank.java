package lotto;

public enum WinningRank {
    FIRST_RANK(0),
    SECOND_RANK(1),
    THIRD_RANK(2),
    FOURTH_RANK(3),
    FIFTH_RANK(4),
    FIRST_COUNT(0),
    SECOND_COUNT(1),
    THIRD_COUNT(1),
    FOURTH_COUNT(2),
    FIFTH_COUNT(3),
    FIRST_RANK_REWARD(2000000000),
    SECOND_RANK_REWARD(30000000),
    THIRD_RANK_REWARD(1500000),
    FOURTH_RANK_REWARD(50000),
    FIFTH_RANK_REWARD(5000);
    private final int value;

    WinningRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
