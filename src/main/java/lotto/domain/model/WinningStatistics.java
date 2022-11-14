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
}
