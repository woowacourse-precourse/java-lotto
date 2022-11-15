package lotto.domain.reward;

import lotto.domain.reward.Reward;

import java.util.List;

public class RewardTable {
    List<Reward> rewards;

    public RewardTable(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
