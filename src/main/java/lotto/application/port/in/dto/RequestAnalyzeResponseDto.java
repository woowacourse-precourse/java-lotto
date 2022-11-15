package lotto.application.port.in.dto;

import lotto.domain.reward.RewardTable;

public class RequestAnalyzeResponseDto {
    private RewardTable rewardTable;

    public RequestAnalyzeResponseDto(RewardTable rewardTable) {
        this.rewardTable = rewardTable;
    }

    public RewardTable getRewardTable() {
        return rewardTable;
    }
}
