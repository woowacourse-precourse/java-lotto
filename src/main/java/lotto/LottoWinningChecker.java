package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {
    private final LottoMetadata lottoMetadata;

    public LottoWinningChecker(LottoMetadata lottoMetadata) {
        this.lottoMetadata = lottoMetadata;
    }

    public Map<Prize, Integer> countWinningLotto(Lotto target, Integer bonus, List<Lotto> lottos) {
        Map<Prize, Integer> countTable = initializeCountTable();

        for (Lotto lotto : lottos) {
            Integer equalNumber = target.compare(lotto);
            if (!lottoMetadata.getPrizeTable()
                    .containsKey(Map.entry(equalNumber, lotto.getNumbers().contains(bonus)))) {
                continue;
            }
            Prize prize = lottoMetadata.getPrizeTable().get(
                    Map.entry(equalNumber, lotto.getNumbers().contains(bonus))
            );
            countTable.put(prize, countTable.get(prize) + 1);
        }
        return countTable;
    }

    private Map<Prize, Integer> initializeCountTable() {
        Map<Prize, Integer> countTable = new HashMap<>();
        for (Prize prize : Prize.values()) {
            countTable.put(prize, 0);
        }
        return countTable;
    }
}
