package lotto.application.service.statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatisticImpl implements WinningStatistic {

    private Map<String, Integer> winInformation = new HashMap<>() {{
        put("three", 0);
        put("four", 0);
        put("five", 0);
        put("fiveContainingBonusNumber", 0);
        put("six", 0);
    }};

    @Override
    public Map<String, Integer> extractStatistic(List<List<Integer>> matchResult) {

        List<Integer> matchResultNotConsiderBonus = matchResult.get(0);
        List<Integer> bonusMatchingCount = matchResult.get(1);

        for (Integer matchResultCount : matchResultNotConsiderBonus) {
            if (matchResultCount == 3) {
                winInformation.put("three", (winInformation.get("three") + 1));
            } else if (matchResultCount == 4) {
                winInformation.put("four", (winInformation.get("four") + 1));
            } else if (matchResultCount == 5) {
                winInformation.put("five", (winInformation.get("five") + 1));
            } else if (matchResultCount == 6) {
                winInformation.put("six", (winInformation.get("six") + 1));
            }
        }
        winInformation = considerBonusNumber(bonusMatchingCount);
        return winInformation;
    }

    @Override
    public Map<String, Integer> considerBonusNumber(List<Integer> bonusMatchingCount) {
        for (Integer bonusMatchingCountResult : bonusMatchingCount) {
            if (bonusMatchingCountResult == 1) {
                winInformation.put("fiveContainingBonusNumber", (winInformation.get("fiveContainingBonusNumber") + 1));
            }
        }
        winInformation.put("five", winInformation.get("five") - winInformation.get("fiveContainingBonusNumber"));

        return winInformation;
    }
}
