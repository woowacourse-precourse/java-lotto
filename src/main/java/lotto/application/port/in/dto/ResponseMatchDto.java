package lotto.application.port.in.dto;

import lotto.domain.result.ResultTable;
import lotto.domain.reward.RewardTable;

public class ResponseMatchDto {

    RewardTable rewardTable;

    private int lottoCount;

    public ResponseMatchDto(RewardTable rewardTable) {
        this.rewardTable = rewardTable;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public RewardTable getRewardTable() {
        return rewardTable;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
