package lotto.model;

import java.util.Map;

public class MatchResult {
    private final Map<MatchType, Integer> matchResult;

    public MatchResult(Map<MatchType, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public int getResultByMatchType(MatchType matchType) {
        return matchResult.get(matchType);
    }

    public double getTotalPrizeMoney() {
        return matchResult.keySet().stream()
                .mapToDouble(matchingLottoType ->
                        matchingLottoType.getPrizeMoney() * matchResult.get(matchingLottoType).doubleValue()
                )
                .sum();
    }
}
