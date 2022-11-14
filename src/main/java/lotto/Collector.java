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
        int bonusNumber = bonusNumberVerifier.askBonusNumber(winningNumbers);

        List<Integer> rankResults = getRankResults(winningNumbers, bonusNumber, lottoList);
        printRankResults(rankResults);

        return rankResults;
    }

    private List<Integer> getRankResults(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottoList) {
        int[] rankResults = new int[5];

        for (Lotto lotto : lottoList) {
            Rank rank = lotto.compare(winningNumbers, bonusNumber);
            rankResults[rank.ordinal()]++;
        }

        return Arrays.stream(rankResults).boxed().collect(Collectors.toList());
    }

    private void printRankResults(List<Integer> results) {
        Rank[] values = Rank.values();

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < values.length; i++) {
            Rank value = values[i];
            System.out.print(value.getMatchingCount() + "개 일치");
            if (i == 3) { // 보너스 볼
                System.out.print(", 보너스 볼 일치");
            }
            System.out.println(" (" + value.getPrize() + "원) - " + results.get(i) + "개\n");
        }
    }
}
