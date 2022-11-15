package lotto.domain.model;

import java.util.Map;
import lotto.domain.model.enums.Reward;

public class WinningStatistics {

    private final Map<Reward, Integer> resultMap;

    public WinningStatistics(Map<Reward, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public int getCountOfReward(Reward reward) {
        return this.resultMap.get(reward);
    }

    public double getRateOfReturn(int money) {
        int sum = 0;
        for (Reward key : resultMap.keySet()) {
            Integer value = resultMap.get(key);
            sum += (key.getPrice() * value.intValue());
        }
        double rateOfReturn = (sum / (double) money) * 100;
        return rateOfReturn;
    }
}
