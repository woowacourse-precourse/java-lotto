package lotto.application.port.in.dto;

import lotto.domain.reward.RewardTable;

public class RequestAnalyzeRevenueDto {
    private RewardTable rewardTable;

    public RequestAnalyzeRevenueDto(RewardTable rewardTable) {
        this.rewardTable = rewardTable;
    }

    public RewardTable getRewardTable() {
        return rewardTable;
    }
}
