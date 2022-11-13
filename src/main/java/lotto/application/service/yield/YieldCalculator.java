package lotto.application.service.yield;

import java.util.List;
import java.util.Map;

public interface YieldCalculator {

    Map<String, Integer> extractStatistic(List<List<Integer>> matchResult);

    Map<String, Integer> considerBonusNumber(List<Integer> bonusMatchingCount);

    void showStatistic(Map<String, Integer> winInformation);

    double extractYield(Map<String, Integer> winInformation, int purchaseMoney);

    void showYield(Map<String, Integer> statistic, int purchaseNumber);
}
