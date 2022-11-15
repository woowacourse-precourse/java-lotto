package lotto.model;

public class Calculator {

    public int getReward(int[] REWARD_LEVEL, int[] result) {
        int reward = 0;

        for (int i = 0; i <= 4; i++) {
            if (result[i] != 0) {
                reward += (REWARD_LEVEL[i] * result[i]);
            }
        }
        return reward;
    }

    public String getRate(int inputMoney, int reward) {
        double rateWithPoint = (reward * 1.0 / inputMoney);

        return String.valueOf(Math.round(rateWithPoint * 10000) / 100.0);
    }
}
