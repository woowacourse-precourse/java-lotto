package lotto;

import static lotto.LottoRank.RANK2;
import static lotto.LottoRank.RANK3;
import static lotto.LottoRank.findRank;
import static lotto.LottoRank.values;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoReader {
    public Map<LottoRank, Integer> createLottoResult(List<Lotto> publishedLotto, Lotto winningLotto, Bonus bonus) {
        Map<Lotto, Integer> matchingResult = createMatchingResult(publishedLotto, winningLotto);
        return putLottoRank(matchingResult, bonus);
    }

    private Map<LottoRank, Integer> putLottoRank(Map<Lotto, Integer> matchingResult, Bonus bonus) {
        Map<LottoRank, Integer> lottoResult = initLottoResult();

        for (Entry<Lotto, Integer> matchingResultEntry : matchingResult.entrySet()) {
            Integer matchingCount = matchingResultEntry.getValue();

            if (matchingCount == 5) {
                putBonusRank(lottoResult, matchingResultEntry, bonus);
            }

            if (matchingCount >= 3) {
                LottoRank findRank = findRank(matchingResultEntry.getValue());
                lottoResult.put(findRank, lottoResult.get(findRank) + 1);
            }
        }

        return lottoResult;
    }

    private void putBonusRank(Map<LottoRank, Integer> lottoResult, Entry<Lotto, Integer> matchingResult, Bonus bonus) {
        Lotto lotto = matchingResult.getKey();

        if (lotto.isMatch(bonus)) {
            lottoResult.put(RANK2, lottoResult.get(RANK2) + 1);
        }

        lottoResult.put(RANK3, lottoResult.get(RANK3) + 1);
    }

    private Map<LottoRank, Integer> initLottoResult() {
        Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : values()) {
            lottoResult.put(rank, 0);
        }

        return lottoResult;
    }

    private Map<Lotto, Integer> createMatchingResult(List<Lotto> publishedLotto, Lotto winningLotto) {
        Map<Lotto, Integer> matchingResult = new HashMap<>();

        for (Lotto lotto : publishedLotto) {
            matchingResult.put(lotto, lotto.countMatchingNumbers(winningLotto));
        }

        return matchingResult;
    }
}
