package lotto.application.port.in.dto;

import lotto.domain.result.ResultTable;
import lotto.domain.reward.RewardTable;

public class ResponseMatchDto {

    RewardTable rewardTable;

    public ResponseMatchDto(RewardTable rewardTable) {
        this.rewardTable = rewardTable;
    }

    public RewardTable getRewardTable() {
        return rewardTable;
    }
}
