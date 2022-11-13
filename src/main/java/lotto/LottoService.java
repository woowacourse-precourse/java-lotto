package lotto;

import lotto.numbers_generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoNumbersGenerator lottoNumbersGenerator = Context.getLottoNumbersGenerator();
    private final Integer lottoPrice = 1000;

    public List<Lotto> purchase(Integer amount) {
        List<Lotto> ret = new ArrayList<>();
        if (amount % lottoPrice != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위 입니다.");
        int lottoQuantity = amount / lottoPrice;
        while (lottoQuantity-- != 0)
            ret.add(new Lotto(lottoNumbersGenerator.generate()));
        return ret;
    }

    public Rank calculateRank(Integer matchingWinningNumberCount, Integer matchingBonusNumberCount) {
        if (matchingWinningNumberCount.equals(6))
            return Rank.FIRST;
        if (matchingWinningNumberCount.equals(5) && matchingBonusNumberCount.equals(1))
            return Rank.SECOND;
        if (matchingWinningNumberCount.equals(5))
            return Rank.THIRD;
        if (matchingWinningNumberCount.equals(4))
            return Rank.FOURTH;
        if (matchingWinningNumberCount.equals(3))
            return Rank.FIFTH;
        return Rank.OUT_OF_RANK;
    }

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        Map<Rank, Integer> ret = new HashMap<>();
        for (var lotto : lottos) {
            Integer matchingWinningNumberCount = winningNumbers.stream()
                    .filter(lotto::contains)
                    .map(e -> 1)
                    .reduce(0, Integer::sum);
            Integer matchingBonusNumberCount = 0;
            if (lotto.contains(bonusNumber))
                ++matchingBonusNumberCount;

            Rank rank = calculateRank(matchingWinningNumberCount, matchingBonusNumberCount);
            ret.put(rank, ret.getOrDefault(rank, 0) + 1);
        }
        return ret;
    }

    public Integer prizeMoney(Rank rank) {
        if (rank.equals(Rank.FIRST))
            return 2000000000;
        if (rank.equals(Rank.SECOND))
            return 30000000;
        if (rank.equals(Rank.THIRD))
            return 1500000;
        if (rank.equals(Rank.FOURTH))
            return 50000;
        if (rank.equals(Rank.FIFTH))
            return 5000;
        return 0;
    }

    public Double calculateYield(Integer purchaseAmount, Map<Rank, Integer> calculatedResult) {
        long prizeMoneySum = calculatedResult.entrySet().stream()
                .mapToLong(e -> Long.valueOf(prizeMoney(e.getKey())) * e.getValue())
                .sum();
        return Double.valueOf(prizeMoneySum) / Double.valueOf(purchaseAmount) * 100.0;
    }
}
