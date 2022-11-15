package lotto.application.service;

import lotto.application.port.in.LottoWinningStatisticsUseCase;
import lotto.application.port.in.dto.RequestAnalyzeRevenueDto;
import lotto.application.port.in.dto.ResponseAnalyzeRevenueDto;
import lotto.domain.reward.Reward;
import lotto.domain.reward.RewardTable;

public class LottoWinningStatisticsService implements LottoWinningStatisticsUseCase {
    @Override
    public ResponseAnalyzeRevenueDto analyzeRevenue(RequestAnalyzeRevenueDto requestAnalyzeResponseDto, int count) {
        double revenueAverage = calculateRevenueAverage(requestAnalyzeResponseDto.getRewardTable(), count);
        double roundAverage = roundAtTwoDigit(revenueAverage);

        return new ResponseAnalyzeRevenueDto(convertPercentUnit(roundAverage));
    }

    private double calculateRevenueAverage(RewardTable rewardTable, int count) {
        final int lottoPrice = 1000;

        int totalRevenue = 0;
        for (Reward reward : rewardTable.getRewards()) {
            totalRevenue += reward.getMoney();
        }

        double inputMoney = count * lottoPrice;

        return totalRevenue / inputMoney;
    }

    private double convertPercentUnit(double revenueAvg) {
        return revenueAvg * 100;
    }

    private double roundAtTwoDigit(double value) {
        return Math.round(value * 10) / 10.0;
    }
}
