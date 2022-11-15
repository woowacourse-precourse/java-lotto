package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.RankAggregationDto;
import lotto.dto.WinningLottoNumberDto;
import lotto.dto.WinningNumberCountDto;

import java.util.List;

public class LottoRankAggregation {

    private int firstRankCount;
    private int secondRankCount;
    private int thirdRankCount;
    private int fourthRankCount;
    private int fifthRankCount;

    public RankAggregationDto rankAggregation(List<Lotto> lottos, WinningLottoNumberDto winningLottoNumberFor) {
        for (Lotto lotto : lottos) {
            WinningNumberCountDto winningNumberCount = lotto.winningLottoNumberCount(winningLottoNumberFor);
            Rank winningRank = Rank.valueOf(winningNumberCount.getWinningCount(), winningNumberCount.isMatchBonusNumber());

            if (winningRank.equals(Rank.FIRST)) {
                firstRankCount += 1;
            }

            if (winningRank.equals(Rank.SECOND)) {
                secondRankCount += 1;
            }

            if (winningRank.equals(Rank.THIRD)) {
                thirdRankCount += 1;
            }

            if (winningRank.equals(Rank.FOURTH)) {
                fourthRankCount += 1;
            }

            if (winningRank.equals(Rank.FIFTH)) {
                fifthRankCount += 1;
            }
        }

        return RankAggregationDto.of(firstRankCount, secondRankCount, thirdRankCount, fourthRankCount, fifthRankCount);
    }
}
