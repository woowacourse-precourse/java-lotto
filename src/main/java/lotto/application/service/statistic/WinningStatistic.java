package lotto.application.service.statistic;

import java.util.List;
import java.util.Map;

public interface WinningStatistic {
    Map<String, Integer> extractStatistic(List<List<Integer>> matchResult);

    Map<String, Integer> considerBonusNumber(List<Integer> bonusMatchingCount);
}
