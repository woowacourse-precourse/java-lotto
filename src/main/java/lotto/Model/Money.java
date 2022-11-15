package lotto.Model;

import java.util.Map;
import lotto.Constant.Result;

public class Money {

    private long prizeMoney;

    public void calculrateReturnRate(Map<String, Integer> savedResult) {
        prizeMoney = 0;
        for (Result key : Result.values()) {
            int value = savedResult.getOrDefault(key.getMatchNumber(), 0);
            prizeMoney += key.calculrate(value);
        }
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
