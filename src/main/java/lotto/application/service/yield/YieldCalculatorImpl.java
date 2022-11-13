package lotto.application.service.yield;

import java.util.HashMap;
import java.util.Map;

import static lotto.application.service.yield.WinningMoney.*;

public class YieldCalculatorImpl implements YieldCalculator {

    private Map<String, Integer> winInformation = new HashMap<>() {{
        put("three", 0);
        put("four", 0);
        put("five", 0);
        put("fiveContainingBonusNumber", 0);
        put("six", 0);
    }};

    @Override
    public double extractYield(Map<String, Integer> winInformation, int purchaseMoney) {
        double yield = 0;

        yield += (double) winInformation.get("three") * (double) (THREE.getWinningMoney());
        yield += (double) winInformation.get("four") * (double) (FOUR.getWinningMoney());
        yield += (double) winInformation.get("five") * (double) (FIVE.getWinningMoney());
        yield += (double) winInformation.get("fiveContainingBonusNumber") * (double) (FIVE_BONUS.getWinningMoney());
        yield += (double) winInformation.get("six") * (double) (SIX.getWinningMoney());
        yield = Math.round((yield / (double) purchaseMoney) * 1000) / 10.0;

        return Math.round(yield * 10) / 10.0;
    }
}
