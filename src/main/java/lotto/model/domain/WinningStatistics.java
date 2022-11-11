package lotto.model.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private static final int INITIAL_COUNT = 0;

    private final Map<Rank, Integer> winningStatistics = new HashMap<>();

    public WinningStatistics(LottoCollection lottoCollection, WinningNumber winningNumber) {
        initialWinningStatistics();

    }

    private void computeRank(Lotto lotto, WinningNumber winningNumber) {

    }


    private void initialWinningStatistics() {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStatistics.put(rank, INITIAL_COUNT));
    }

}
