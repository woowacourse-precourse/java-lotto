package lotto.domain;

import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> results;

    private Result(Map<Rank, Integer> results) {
        this.results = results;
    }

    public static Result of(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<Rank, Integer> results = Rank.getRankWithCount();

        for (Lotto lotto : lottos) {
            int matchingCount = winningNumber.getMatchingCount(lotto);
            boolean hasBonusNumber = winningNumber.hasBonusNumber(lotto);
            Rank rank = Rank.of(matchingCount, hasBonusNumber);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return new Result(results);
    }
}
