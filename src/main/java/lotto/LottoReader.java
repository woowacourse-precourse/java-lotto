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
    private final Map<LottoRank, Integer> lottoResult;

    public LottoReader() {
        this.lottoResult = initLottoResult();
    }

    public double calculateYield(int purchaseAmount) {
        int totalWinningAmount = calculateTotalAmount();
        return (double) totalWinningAmount / purchaseAmount * 100;
    }

    public Map<LottoRank, Integer> createLottoResult(List<Lotto> publishedLotto, Lotto winningLotto, Bonus bonus) {
        Map<Lotto, Integer> matchingResult = createMatchingResult(publishedLotto, winningLotto);
        putLottoRank(matchingResult, bonus);
        return lottoResult;
    }

    private int calculateTotalAmount() {
        int totalWinningAmount = 0;

        for (Entry<LottoRank, Integer> lottoResultEntry : lottoResult.entrySet()) {
            LottoRank rank = lottoResultEntry.getKey();
            Integer count = lottoResultEntry.getValue();

            totalWinningAmount += rank.calculateTotalAmount(count);
        }

        return totalWinningAmount;
    }

    private void putLottoRank(Map<Lotto, Integer> matchingResult, Bonus bonus) {
        for (Entry<Lotto, Integer> matchingResultEntry : matchingResult.entrySet()) {
            Integer matchingCount = matchingResultEntry.getValue();

            if (matchingCount == 5) {
                putBonusRank(matchingResultEntry, bonus);
            }

            if (matchingCount >= 3) {
                LottoRank findRank = findRank(matchingResultEntry.getValue());
                lottoResult.put(findRank, lottoResult.get(findRank) + 1);
            }
        }
    }

    private void putBonusRank(Entry<Lotto, Integer> matchingResult, Bonus bonus) {
        Lotto lotto = matchingResult.getKey();

        if (lotto.isMatch(bonus)) {
            lottoResult.put(RANK2, lottoResult.get(RANK2) + 1);
        }

        lottoResult.put(RANK3, lottoResult.get(RANK3) + 1);
    }

    private Map<LottoRank, Integer> initLottoResult() {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : values()) {
            result.put(rank, 0);
        }

        return result;
    }

    private Map<Lotto, Integer> createMatchingResult(List<Lotto> publishedLotto, Lotto winningLotto) {
        Map<Lotto, Integer> matchingResult = new HashMap<>();

        for (Lotto lotto : publishedLotto) {
            matchingResult.put(lotto, lotto.countMatchingNumbers(winningLotto));
        }

        return matchingResult;
    }
}
