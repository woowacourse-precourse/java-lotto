package lotto.application.service;

import lotto.application.port.in.LottoWinningStatisticsUseCase;
import lotto.application.port.in.dto.RequestAnalyzeResponseDto;
import lotto.application.port.in.dto.ResponseAnalyzeRevenueDto;
import lotto.domain.reward.Reward;
import lotto.domain.reward.RewardTable;

public class LottoWinningStatisticsService implements LottoWinningStatisticsUseCase {
    @Override
    public ResponseAnalyzeRevenueDto analyzeRevenue(RequestAnalyzeResponseDto requestAnalyzeResponseDto, int count) {
        double revenueAverage = calculateRevenueAverage(requestAnalyzeResponseDto.getRewardTable(), count);

        return new ResponseAnalyzeRevenueDto(roundAtTwoDigit(revenueAverage));
    }

    private double calculateRevenueAverage(RewardTable rewardTable, int count) {
        int totalRevenue = 0;
        for (Reward reward : rewardTable.getRewards()) {
            totalRevenue += reward.getMoney();
        }

        return totalRevenue / count;
    }

    private double roundAtTwoDigit(double value) {
        return Math.round(value * 10) / 10.0;
    }
}
