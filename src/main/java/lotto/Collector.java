package lotto;

import lotto.verifier.BonusNumberVerifier;
import lotto.verifier.WinningNumberVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        int[] rankResults = new int[5];

        for(Lotto lotto:lottoList) {
            Rank rank = lotto.compare(winningNumbers, bonusNumber);
            rankResults[rank.ordinal()]++;
        }

        return Arrays.stream(rankResults).boxed().collect(Collectors.toList());
    }

    private void printRankResults(List<Integer> results) {

    }
}
