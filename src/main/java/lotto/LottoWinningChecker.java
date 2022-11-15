package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {
    private final LottoMetadata lottoMetadata;

    public LottoWinningChecker(LottoMetadata lottoMetadata) {
        this.lottoMetadata = lottoMetadata;
    }

    public Map<Prize, Integer> countWinningLotto(Lotto target, List<Lotto> lottos, Integer bonus) {
        Map<Prize, Integer> countTable = initializeCountTable();
        Integer equalNumber;
        for (Lotto lotto : lottos) {
            equalNumber = target.compare(lotto);
            Prize prize = lottoMetadata.getPrizeTable()
                    .get(Map.entry(equalNumber, lotto.getNumbers().contains(bonus)));
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
