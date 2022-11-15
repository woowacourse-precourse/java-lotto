package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Lotto winningLotto;
    private final Number bonusNumber;
    private final Map<Rank, Integer> results;

    public WinningResult(Lotto winningLotto, Number bonusNumber, Map<Rank, Integer> results) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.results = results;
    }

    public WinningResult(Lotto winningLotto, Number bonusNumber) {
        this(winningLotto, bonusNumber, new HashMap<>());
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public void compareLotto(Lotto purchaseLotto) {
        Rank rank = Rank.decide(countCoincide(purchaseLotto), isCoincideBonus(purchaseLotto));
        addRank(rank);
    }

    private boolean isCoincideBonus(Lotto purchaseLotto) {
        return purchaseLotto.getNumbers().contains(bonusNumber);
    }

    private long countCoincide(Lotto purchaseLotto) {
        return purchaseLotto.getNumbers()
                .stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public void addRank(Rank rank) {
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }
}
