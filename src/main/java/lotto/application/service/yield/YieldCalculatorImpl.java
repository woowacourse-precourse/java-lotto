package lotto.application.service.yield;

import java.util.Map;

import static lotto.application.service.statistic.WinningMoney.*;

public class YieldCalculatorImpl implements YieldCalculator {

    @Override
    public double extractYield(Map<String, Integer> winInformation, int purchaseMoney) {
        double yield = 0;

        yield += (double) winInformation.get("fifth") * (double) (FIFTH.getWinningMoney());
        yield += (double) winInformation.get("fourth") * (double) (FOURTH.getWinningMoney());
        yield += (double) winInformation.get("third") * (double) (THIRD.getWinningMoney());
        yield += (double) winInformation.get("second") * (double) (SECOND.getWinningMoney());
        yield += (double) winInformation.get("first") * (double) (FIRST.getWinningMoney());
        yield = Math.round((yield / (double) purchaseMoney) * 1000) / 10.0;

        return Math.round(yield * 10) / 10.0;
    }
}
