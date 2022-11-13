package lotto;

import lotto.numbers_generator.Context;
import lotto.numbers_generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoNumbersGenerator lottoNumbersGenerator = Context.getLottoNumbersGenerator();
    private final Integer lottoPrice = 1000;

    List<Lotto> purchase(Integer amount) {
        List<Lotto> ret = new ArrayList<>();
        if (amount % lottoPrice != 0)
            throw new IllegalArgumentException();
        int lottoQuantity = amount / lottoPrice;
        while (lottoQuantity-- != 0)
            ret.add(new Lotto(lottoNumbersGenerator.generate()));
        return ret;
    }

    Rank calculateRank(Integer matchingWinningNumberCount, Integer matchingBonusNumberCount) {
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

    Map<Rank, Integer> calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
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
}
