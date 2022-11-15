package lotto.application.service.statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatisticImpl implements WinningStatistic {

    private Map<String, Integer> winInformation = new HashMap<>() {{
        put("fifth", 0);
        put("fourth", 0);
        put("third", 0);
        put("second", 0);
        put("first", 0);
    }};

    @Override
    public Map<String, Integer> extractStatistic(List<List<Integer>> matchResult) {

        List<Integer> matchResultNotConsiderBonus = matchResult.get(0);
        List<Integer> bonusMatchingCount = matchResult.get(1);

        for (Integer matchResultCount : matchResultNotConsiderBonus) {
            if (matchResultCount == 3) {
                winInformation.put("fifth", (winInformation.get("fifth") + 1));
            } else if (matchResultCount == 4) {
                winInformation.put("fourth", (winInformation.get("fourth") + 1));
            } else if (matchResultCount == 5) {
                winInformation.put("third", (winInformation.get("third") + 1));
            } else if (matchResultCount == 6) {
                winInformation.put("first", (winInformation.get("first") + 1));
            }
        }
        winInformation = considerBonusNumber(bonusMatchingCount);
        return winInformation;
    }

    @Override
    public Map<String, Integer> considerBonusNumber(List<Integer> bonusMatchingCount) {
        for (Integer bonusMatchingCountResult : bonusMatchingCount) {
            if (bonusMatchingCountResult == 1) {
                winInformation.put("second", (winInformation.get("second") + 1));
            }
        }
        winInformation.put("third", winInformation.get("third") - winInformation.get("second"));

        return winInformation;
    }
}
