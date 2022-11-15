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

    public int getCountOfRank(int rank) {
        return (int) this.rewards.stream().filter(reward -> reward.getRank() == rank).count();
    }

}
