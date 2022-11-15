package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Lotto, LottoRank> ranks;
    private final Long totalCost;
    private final Long totalPrize;
    private final Double earningsRatio;

    public LottoResult(Map<Lotto, LottoRank> ranks) {
        this.ranks = ranks;
        this.totalCost = ranks.size() * (long) (LottoRule.TICKET_COST);
        this.totalPrize = LottoResultCalculator.calculateTotalPrize(ranks);
        this.earningsRatio = LottoResultCalculator.calculateEarningsRatio(totalCost, totalPrize);
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public Map<Lotto, LottoRank> getRanks() {
        return ranks;
    }

    public Long getTotalPrize() {
        return totalPrize;
    }

    public Double getEarningsRatio() {
        return earningsRatio;
    }
}

