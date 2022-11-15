package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Lotto winningLotto;
    private final Number bonusNumber;
    private final Map<Rank, Integer> results = new EnumMap<Rank, Integer>(Rank.class);

    public WinningResult(Lotto winningLotto, Number bonusNumber) {
        validateBonusDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusDuplicate(Lotto winningLotto, Number bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
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
