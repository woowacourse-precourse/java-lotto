package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.model.LottoWinningStatus.*;

public class LottoWinningStatistics {

    private Map<LottoWinningStatus, Integer> winningCounts;
    private double earningsRate;

    public LottoWinningStatistics() {
        initWinningCounts();
        earningsRate = 0;
    }

    private void initWinningCounts() {
        winningCounts = new LinkedHashMap<>();
        winningCounts.put(MATCH_THREE_NUMBERS, 0);
        winningCounts.put(MATCH_FOUR_NUMBERS, 0);
        winningCounts.put(MATCH_FIVE_NUMBERS, 0);
        winningCounts.put(MATCH_FIVE_NUMBERS_WITH_BONUS_NUMBERS, 0);
        winningCounts.put(MATCH_SIX_NUMBERS, 0);
    }
}
