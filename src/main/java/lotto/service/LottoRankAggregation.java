package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.RankAggregationDto;
import lotto.dto.WinningLottoNumberDto;
import lotto.dto.WinningNumberCountDto;

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

    public RankAggregationDto getRankAggregation(List<Lotto> lottos, WinningLottoNumberDto winningLottoNumberDto) {
        for (Lotto lotto : lottos) {
            WinningNumberCountDto winningNumberCount = lotto.winningLottoNumberCount(winningLottoNumberDto);
            Rank winningRank = Rank.valueOf(winningNumberCount.getWinningCount(), winningNumberCount.isMatchBonusNumber());

            if (winningRank.equals(Rank.LOSE)) {
                continue;
            }

            rankAggregationMap.put(winningRank, rankAggregationMap.computeIfPresent(winningRank, (rank, count) -> count += 1));
        }

        return RankAggregationDto.of(rankAggregationMap);
    }
}
