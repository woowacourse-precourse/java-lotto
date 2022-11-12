package lotto.domain.chart;

public enum RankChart {
    FirstPlace(6), SecondPlace(7), ThirdPlace(5), FourthPlace(4), FifthPlace(3);

    private final int value;

    RankChart(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
