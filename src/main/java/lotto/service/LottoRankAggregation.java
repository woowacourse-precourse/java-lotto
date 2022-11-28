package lotto.service;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.ResponseRankAggregationDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankAggregation {

    private Map<Rank, Integer> rankAggregationMap = new EnumMap<>(Rank.class) {{
        put(Rank.FIRST, 0);
        put(Rank.SECOND, 0);
        put(Rank.THIRD, 0);
        put(Rank.FOURTH, 0);
        put(Rank.FIFTH, 0);
    }};

    public ResponseRankAggregationDto aggregation(Customer customer, List<Integer> winningLotto, int bonusNumber) {
        for (Lotto lotto : customer.getLottos()) {
            Rank winningRank = Rank.valueOf(getWinningCount(winningLotto, lotto), isMatchBonusNumber(bonusNumber, lotto));

            if (winningRank.equals(Rank.LOSE)) {
                continue;
            }

            rankAggregationMap.put(winningRank, rankAggregationMap.computeIfPresent(winningRank, (rank, count) -> count += 1));
        }

        return ResponseRankAggregationDto.of(rankAggregationMap);
    }

    private static boolean isMatchBonusNumber(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .anyMatch(number -> number.equals(bonusNumber));
    }

    private static int getWinningCount(List<Integer> winningLotto, Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }
}
