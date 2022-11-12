package lotto;

import java.util.List;

public class LottoRankAggregation {

    private int firstRankCount;
    private int secondRankCount;
    private int thirdRankCount;
    private int fourthRankCount;
    private int fifthRankCount;

    public ResponseRankAggregation rankAggregation(List<Lotto> lottos, WinningLottoNumber winningLottoNumberFor) {
        for (Lotto lotto : lottos) {
            WinningNumberCount winningNumberCount = lotto.winningLottoNumberCount(winningLottoNumberFor);
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

        return ResponseRankAggregation.of(firstRankCount, secondRankCount, thirdRankCount, fourthRankCount, fifthRankCount);
    }
}
