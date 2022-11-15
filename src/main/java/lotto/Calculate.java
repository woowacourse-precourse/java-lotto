package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculate {

    // 수익률을 계산하는 기능
    public static String getProfitRate(long purchaseAmount, long winningAmount) {
        return String.format("%.1f", (double) winningAmount / purchaseAmount * 100);
    }

    // 당첨 결과를 계산하는 기능
    public static Map<LottoMatch, Long> getWinningDetails(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoMatch, Long> winningDetails = new HashMap<>();
        long[] winningArray = getWinningResult(lottos, winningNumbers, bonusNumber);
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            winningDetails.put(lottoMatch, winningArray[lottoMatch.getIdx()]);
        }
        return winningDetails;
    }

    // 당첨 결과를 idx에 맞춰 배열에 담는 기능
    public static long[] getWinningResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        long[] winningArray = new long[5];
        for (Lotto lotto : lottos) {
            int winningCount = lotto.compareWithWinningNumbers(winningNumbers);
            boolean isWinBonusNumber = lotto.compareWithBonusNumber(bonusNumber);
            int idx = winningCountAndBonusNumberToIdx(winningCount, isWinBonusNumber);
            if (winningCount >= 3) {
                winningArray[idx]++;
            }
        }
        return winningArray;
    }

    // 비교결과를 바탕으로 당첨 결과에 해당하는 인덱스를 리턴하는 기능
    public static int winningCountAndBonusNumberToIdx(int winningCount, boolean isWinBonusNumber) {
        int idx = winningCount-3;
        if (winningCount == 5 && isWinBonusNumber || winningCount == 6) {
            idx++;
        }
        return idx;
    }

}
