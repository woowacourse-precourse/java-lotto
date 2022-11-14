package lotto;

import lotto.verifier.BonusNumberVerifier;
import lotto.verifier.WinningNumberVerifier;

import java.util.List;

public class Collector {

    public List<Integer> collectRankResults(List<Lotto> lottoList) {
        WinningNumberVerifier winningNumberVerifier = new WinningNumberVerifier();
        BonusNumberVerifier bonusNumberVerifier = new BonusNumberVerifier();

        List<Integer> winningNumbers = winningNumberVerifier.askWinningNumber();
        int bonusNumber = bonusNumberVerifier.askBonusNumber();

        List<Integer> RankResults = getRankResults(winningNumbers, bonusNumber, lottoList);
        printRankResults(RankResults);

        return null;
    }

    private List<Integer> getRankResults(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottoList) {
        return null;
    }

    private void printRankResults(List<Integer> results) {

    }
}
