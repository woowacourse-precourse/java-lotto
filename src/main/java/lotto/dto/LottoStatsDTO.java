package lotto.dto;

import java.util.List;

public class LottoStatsDTO {
    private final List<Integer> rankCounts;
    private final double yieldPercent;

    public LottoStatsDTO(List<Integer> rankCounts, double yieldPercent) {
        this.rankCounts = rankCounts;
        this.yieldPercent = yieldPercent;
    }

    public List<Integer> getRankCounts() {
        return rankCounts;
    }

    public double getYieldPercent() {
        return yieldPercent;
    }
}
