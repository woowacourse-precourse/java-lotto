package lotto.service;

public enum RankChart {
    FIRST_PLACE(6),
    SECOND_PLACE(7),
    THIRD_PLACE(5),
    FOURTH_PLACE(4),
    FIFTH_PLACE(3);

    private final int value;

    RankChart(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
