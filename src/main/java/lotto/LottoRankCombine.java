package lotto;

import java.util.List;

public class LottoRankCombine {

    private int firstCount = 0;
    private int secondCount = 0;
    private int thirdCount = 0;
    private int fourthCount = 0;
    private int fifthCount = 0;

    public ResponseRankCombine rankCombine(List<Lotto> lottos, WinningLottoNumber winningLottoNumberFor) {
        for (Lotto lotto : lottos) {
            WinningNumberCount winningNumberCount = lotto.winningLottoNumberCount(winningLottoNumberFor);
            Rank winningRank = Rank.valueOf(winningNumberCount.getWinningCount(), winningNumberCount.isMatchBonusNumber());

            if (winningRank == Rank.FIRST) {
                firstCount += 1;
                continue;
            }

            if (winningRank == Rank.SECOND) {
                secondCount += 1;
                continue;
            }

            if (winningRank == Rank.THIRD) {
                thirdCount += 1;
                continue;
            }

            if (winningRank == Rank.FOURTH) {
                fourthCount += 1;
                continue;
            }

            if (winningRank == Rank.FIFTH) {
                fifthCount += 1;
            }
        }

        return ResponseRankCombine.of(firstCount, secondCount, thirdCount, fourthCount, fifthCount);
    }
}
