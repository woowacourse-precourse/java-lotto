package lotto.domain;

import lotto.Rank;

import java.util.List;

public class LottoReward {
    private int reward = 0;
    private float rewardRate = 0;

    public void setReward(LottoResult lottoResult){
        List<Rank> ranks = lottoResult.getRanks();

        for (int i = 0; i < ranks.size(); i++) {
                reward += ranks.get(i).getReward();
            }
        }

        public void setRewardRate(Money money){
            rewardRate = (float) reward / money.getMoney() * 100;
        }

        public int getReward(){
            return reward;
        }

        public float getRewardRate(){
            return rewardRate;
        }
}


