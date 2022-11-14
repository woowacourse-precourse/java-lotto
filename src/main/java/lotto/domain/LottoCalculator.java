package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public static Map<LottoMatch, Integer> prizeByMatchCount = Map.ofEntries(
            Map.entry(LottoMatch.THREE, 5000),
            Map.entry(LottoMatch.FOUR, 50_000),
            Map.entry(LottoMatch.FIVE, 1_500_000),
            Map.entry(LottoMatch.BONUS, 30_000_000),
            Map.entry(LottoMatch.SIX, 2_000_000_000)
    );

    public Map<LottoMatch, Integer> calWinningPrize(List<Lotto> lottoPacks, List<Integer> winningNumber, Integer bonusNumber) {
        final Map<LottoMatch, Integer> matchCount = new HashMap<>();

        lottoPacks.forEach(lotto -> {
            LottoMatch lottoMatch = lotto.matchedCount(winningNumber, bonusNumber);

            matchCount.merge(lottoMatch, 1, (key, count) -> count + 1);
        });

        return matchCount;
    }

    public Double calEarningRate(Integer price, Map<LottoMatch, Integer> matchedCount) {
        double allPrize = 0D;

        for (LottoMatch match : LottoMatch.values()) {
            Integer count = matchedCount.getOrDefault(match, 0);
            Integer prize = prizeByMatchCount.getOrDefault(match, 0);

            allPrize += prize * count;
        }

        double rate = (allPrize / price) * 100;
        return (Math.round(rate * 10)) / 10.0;
    }
}
