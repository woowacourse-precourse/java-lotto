package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public class LottoResult {
    private final Map<Lotto, LottoRank> ranks;
    private final Long totalCost;
    private final BigInteger totalPrize;
    private final BigDecimal earningsRatio;

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

    public BigInteger getTotalPrize() {
        return totalPrize;
    }

    public BigDecimal getEarningsRatio() {
        return earningsRatio;
    }
}

