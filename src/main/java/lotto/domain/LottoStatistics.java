package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoStatistics {
    private final WinningNumber winningNumber;

    private Map<Rank, Integer> results;

    public LottoStatistics(List<Lotto> lottoBundle, WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
        results = new HashMap<>();
        setResults(lottoBundle);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    private void setResults(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            Rank rank = getRank(lotto);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank getRank(Lotto lotto) {
        Rank currentRank = null;
        for (Rank rank : Rank.values()) {
            if (rank.getMatchingCount() == getMatchingCount(lotto)) {
                currentRank = rank;
                break;
            }
        }
        return currentRank;
    }

    private int getMatchingCount(Lotto lotto) {
        long count = lotto.getNumbers().stream()
                .filter(e -> winningNumber.getNumbers().contains(e))
                .count();
        if (count == 5 && lotto.getNumbers().contains(winningNumber.getBonusNumber())) {
            count += 2;
        }
        return (int)count;
    }
}
