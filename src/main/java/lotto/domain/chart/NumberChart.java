package lotto.domain.chart;

public enum NumberChart {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_MONEY(1000),
    LOTTO_SIZE(6);

    private final int value;

    NumberChart(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

