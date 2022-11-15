package lotto.controller.result;

import lotto.domain.statistics.Statistics;

public class WinningResult {

    private final Statistics statistics;

    public WinningResult(final Statistics statistics) {
        this.statistics = statistics;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
