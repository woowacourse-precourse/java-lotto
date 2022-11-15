package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {
    private final Map<Rank, Integer> ranks;

    public RankCalculator(List<Lotto> lottoPapers, ProvidNumber providNumber) {
        this.ranks = countRank(lottoPapers,providNumber);
    }

    private Map<Rank, Integer> countRank(List<Lotto> lottoPapers, ProvidNumber providNumber) {
        Map<Rank, Integer> ranks = initializeRank();

        for (int i = 0; i < lottoPapers.size(); i++) {
            Rank rank = compareLottoAndProvideNumber(lottoPapers.get(i), providNumber);
            ranks.put(rank, ranks.get(rank) + 1);
        }
        return ranks;
    }

    public Map<Rank, Integer> initializeRank() {
        Map<Rank, Integer> ranks = new HashMap<>();

        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }

    private Rank compareLottoAndProvideNumber(Lotto lottoPaper, ProvidNumber providNumber) {
        List<Integer> lotto = new ArrayList<>(lottoPaper.getNumbers());
        int sameCount = (int) lotto.stream()
                .filter(providNumber.getWinningNumbers().getNumbers()::contains)
                .count();

        return changeRank(sameCount, compareBonusNumber(lottoPaper, providNumber.getBonusNumber()));
    }

    private Rank changeRank(int count, boolean isSecond) {
        for (Rank rank : Rank.values()) {
            if (count == Rank.SECOND_PLACE.getCorrectCount() && isSecond) {
                return Rank.SECOND_PLACE;
            }
            if (count == rank.getCorrectCount()) {
                return rank;
            }
        }
        return Rank.NONE;
    }

    private boolean compareBonusNumber(Lotto lottoPaper, int bonusNumber) {
        return lottoPaper.getNumbers().contains(bonusNumber);
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }
}
