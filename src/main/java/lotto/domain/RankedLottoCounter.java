package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankedLottoCounter {
    private Map<Ranking, Integer> numberOfRankedLottos;
    private WinningLotto winningLotto;

    public RankedLottoCounter(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        init();
    }

    private void init() {
        numberOfRankedLottos = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            numberOfRankedLottos.put(ranking, 0);
        }
    }

    public  Map<Ranking, Integer> countRankedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int numberOfMatchNumbers = winningLotto.countMatchNumber(lotto);
            boolean bonusNumberMatch = winningLotto.checkBonusNumber(lotto);
            Ranking ranking = Ranking.getRank(numberOfMatchNumbers, bonusNumberMatch);
            int currentCount = numberOfRankedLottos.get(ranking);

            numberOfRankedLottos.put(ranking, currentCount + 1);
        }
        return numberOfRankedLottos;
    }
}
