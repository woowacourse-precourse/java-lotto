package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    private static final Integer INITIAL_COUNT = 0;
    private Map<Rank, Integer> winningResult = new HashMap<>();

    public LottoCalculator(WinningLotto winningLotto, List<LottoGenerator> generatedLottos) {
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, INITIAL_COUNT);
        }
        calculateStatistic(winningLotto, generatedLottos);
    }

    private void calculateStatistic(WinningLotto winningLotto, List<LottoGenerator> generatedLottos) {
        for (LottoGenerator generatedLotto : generatedLottos) {
            Rank rank = calculateRankStatus(winningLotto,generatedLotto);
            Integer count = winningResult.get(rank);
            winningResult.put(rank, count + 1);
        }
    }

    public Map<Rank, Integer> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }

    private Rank calculateRankStatus(WinningLotto winningLotto, LottoGenerator generatedLotto) {
        int sameNumberCount = 0;
        for (Integer number : generatedLotto.getSortedRandomLotto()) {
            if (winningLotto.getLottoNumbers().contains(number)) {
                sameNumberCount += 1;
            }
        }
        if (sameNumberCount == 5 && containsBonus(winningLotto,generatedLotto)) {
            return Rank.SECOND;
        }
        return Rank.getRank(sameNumberCount, containsBonus(winningLotto,generatedLotto));
    }

    private static boolean containsBonus(WinningLotto winningLotto, LottoGenerator generatedLotto) {
        return generatedLotto.getSortedRandomLotto().contains(winningLotto.getBonusNumber());
    }
}
