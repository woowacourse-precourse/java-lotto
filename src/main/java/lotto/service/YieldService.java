package lotto.service;

import lotto.dto.ResponseRankAggregationDto;

public class YieldService {
    public String calculate(ResponseRankAggregationDto rankAggregationDto, int payment) {
        double totalWinningMoney = getTotalWinningMoney(rankAggregationDto);
        double yield = getYield(payment, totalWinningMoney);
        return String.format("%.1f", yield);
    }

    private double getTotalWinningMoney(ResponseRankAggregationDto rankAggregationDto) {
        return rankAggregationDto.getRankAggregationMap()
                .entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    private double getYield(int payment, double totalWinningMoney) {
        return (totalWinningMoney / payment) * 100;
    }
}
