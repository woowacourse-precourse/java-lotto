package lotto.application.service.yield;

import java.util.Map;

public interface YieldCalculator {
    double extractYield(Map<String, Integer> winInformation, int purchaseMoney);
}
