package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Integer firstPlaceCount;
    private final Integer secondPlaceCount;
    private final Integer thirdPlaceCount;
    private final Integer fourthPlaceCount;
    private final Integer fifthPlaceCount;
    private final Long totalCost;
    private final Long totalPrize;
    private final Double earningsRatio;

    public LottoResult(int count, Map<LottoRank, Integer> ranks) {
        this.firstPlaceCount = ranks.get(LottoRank.FIRST_PLACE);
        this.secondPlaceCount = ranks.get(LottoRank.SECOND_PLACE);
        this.thirdPlaceCount = ranks.get(LottoRank.THIRD_PLACE);
        this.fourthPlaceCount = ranks.get(LottoRank.FOURTH_PLACE);
        this.fifthPlaceCount = ranks.get(LottoRank.FIFTH_PLACE);
        this.totalCost = count * (long) (LottoRule.TICKET_COST);
        this.totalPrize = LottoResultCalculator.calculatePrize(ranks);
        this.earningsRatio = LottoResultCalculator.calculateEarningsRatio(totalCost, totalPrize);
    }

    public Integer getFirstPlaceCount() {
        return firstPlaceCount;
    }

    public Integer getSecondPlaceCount() {
        return secondPlaceCount;
    }

    public Integer getThirdPlaceCount() {
        return thirdPlaceCount;
    }

    public Integer getFourthPlaceCount() {
        return fourthPlaceCount;
    }

    public Integer getFifthPlaceCount() {
        return fifthPlaceCount;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public Long getTotalPrize() {
        return totalPrize;
    }

    public Double getEarningsRatio() {
        return earningsRatio;
    }
}

