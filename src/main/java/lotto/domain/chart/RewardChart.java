package lotto.domain.chart;

public enum RewardChart {
    First(2_000_000_000), Second(30_000_000), Third(1_500_000), Fourth(50_000), Fifth(5_000);

    private final int value;

    RewardChart(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
