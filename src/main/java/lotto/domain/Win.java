package lotto.domain;

import java.util.*;

import static lotto.domain.Rank.*;

public class Win {
    private Map<Rank, Integer> ranking;

    public Win() {
        this(initRanking());
    }

    public Win(Map<Rank, Integer> ranking) {
        this.ranking = ranking;
    }

    public void compareAllLotto(Ticket ticket, List<Integer> winningNumbers, int bonusNumber) {
        int lottoCount = ticket.size();
        Comparison comparison = new Comparison();

        for (int lottoIndex = 0; lottoIndex < lottoCount; lottoIndex++) {
            Lotto lotto = ticket.get(lottoIndex);
            compareLotto(winningNumbers, bonusNumber, comparison, lotto);
        }
    }

    private void compareLotto(List<Integer> winningNumbers, int bonusNumber, Comparison comparison, Lotto lotto) {
        int win = comparison.countWinningNumbers(lotto, winningNumbers);
        int bonus = comparison.countBonusNumber(lotto, bonusNumber);

        Rank rank = findByWinAndBonus(win, bonus);

        if (rank.isEtc()) {
            return;
        }

        increaseRankCount(rank);
    }

    private void increaseRankCount(Rank rank) {
        ranking.put(rank, ranking.get(rank) + 1);
    }

    private static Map<Rank, Integer> initRanking() {
        Map<Rank, Integer> ranking = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }

        return ranking;
    }

    public List<Integer> getWinningsCount() {
        return new ArrayList<>(ranking.values());
    }

    public double getWinnings() {
        double total = 0;

        for (Rank rank : Rank.values()) {
            total += rank.getWinnings() * ranking.get(rank);
        }

        return total;
    }
}
