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

    public void compareLotto(Lotto lotto) {
        Rank.decide(countCoincide(lotto), isCoincideBonus());
    }

    private boolean isCoincideBonus() {
        return winningLotto.getNumbers().contains(bonusNumber);
    }

    private long countCoincide(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    public void add(Rank rank) {
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }
}
