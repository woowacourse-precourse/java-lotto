package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Lotto winningLotto;
    private final Number bonusNumber;
    private final Map<Rank, Integer> results = new EnumMap<Rank, Integer>(Rank.class);

    public WinningResult(Lotto winningLotto, Number bonusNumber) {
        validateBonusDuplicate(winningLotto, bonusNumber);
        initRanks();
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void initRanks() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    private void validateBonusDuplicate(Lotto winningLotto, Number bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public Map<Rank, Integer> getResults() {
        results.remove(Rank.NONE);
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
        results.put(rank, results.get(rank) + 1);
    }

    public double calculateTotalWinningAmount() {
        double totalWinningAmount = 0L;
        for (Map.Entry<Rank, Integer> result : results.entrySet()) {
            totalWinningAmount += result.getKey().winningAmount * result.getValue();
        }

        return totalWinningAmount;
    }
}
