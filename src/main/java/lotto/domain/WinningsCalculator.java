package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningsCalculator {
    private Map<Ranking, Integer> numberOfRankedLottos;
    private WinningLotto winningLotto;

    public WinningsCalculator(List<Lotto> lottos, WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        numberOfRankedLottos = countRankedLottos(lottos);
    }

    private  Map<Ranking, Integer> countRankedLottos(List<Lotto> lottos) {
        Map<Ranking, Integer> numberOfRankedLottos = new EnumMap<>(Ranking.class);

        for (Lotto lotto : lottos) {
            int numberOfMatchNumbers = winningLotto.countMatchNumber(lotto);
            boolean bonusNumberMatch = winningLotto.checkBonusNumber(lotto);
            Ranking ranking = Ranking.getRank(numberOfMatchNumbers, bonusNumberMatch);

            int currentCount = 0;
            if (numberOfRankedLottos.containsKey(ranking)) {
                currentCount = numberOfRankedLottos.get(ranking);
            }

            numberOfRankedLottos.put(ranking, currentCount + 1);
        }
        return numberOfRankedLottos;
    }

    public long calculateWinnings() {
        long winnings = 0L;
        for (Map.Entry<Ranking, Integer> entry : numberOfRankedLottos.entrySet()) {
            winnings += (long) entry.getKey().getReward() * entry.getValue();
        }
        return winnings;
    }

    public Map<Ranking, Integer> getNumberOfRankedLottos() {
        return numberOfRankedLottos;
    }
}
