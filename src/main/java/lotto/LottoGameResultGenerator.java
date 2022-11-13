package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResultGenerator {
    public static LottoGameResult generateLottoGameResult(List<Lotto> lottos,
                                                          WinningNumbers winningNumbers,
                                                          BonusNumber bonusNumber) {
        Map<Integer, Integer> winningDetails = new HashMap<>();
        initializeWinningDetails(winningDetails);
        calculateWinningDetails(winningDetails, lottos, winningNumbers, bonusNumber);
        LottoGameResult lottoGameResult = new LottoGameResult();
        return lottoGameResult;
    }

    private static void initializeWinningDetails(Map<Integer, Integer> winningDetails) {
        winningDetails.put(5_000, 0);
        winningDetails.put(50_000, 0);
        winningDetails.put(1_500_000, 0);
        winningDetails.put(30_000_000, 0);
        winningDetails.put(2_000_000_000, 0);
    }

    private static void calculateWinningDetails(Map<Integer, Integer> winningDetails,
                                                List<Lotto> lottos,
                                                WinningNumbers winningNumbers,
                                                BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            int winningCount = getWinningCount(lotto, winningNumbers);
            updateWinningDetails(lotto, winningDetails, bonusNumber, winningCount);
        }
    }

    private static int getWinningCount(Lotto lotto, WinningNumbers winningNumbers) {
        int winningCount = 0;
        for (int number : winningNumbers.getNumbers()) {
            if (lotto.contains(number)) {
                winningCount += 1;
            }
        }
        return winningCount;
    }

    private static void updateWinningDetails(Lotto lotto, Map<Integer, Integer> winningDetails,
                                          BonusNumber bonusNumber, int winningCount) {
        if (winningCount < 3) {
            return;
        }

        int prizeMoney = getPrizeMoneyByWinningCount(lotto, bonusNumber, winningCount);
        int oldValue = winningDetails.get(prizeMoney);
        int newValue = oldValue + 1;
        winningDetails.put(prizeMoney, newValue);
    }

    private static int getPrizeMoneyByWinningCount(Lotto lotto, BonusNumber bonusNumber, int winningCount) {
        if (winningCount == 6) {
            return 2_000_000_000;
        }
        if (winningCount == 5) {
            if (lotto.contains(bonusNumber.getNumber())) {
                return 30_000_000;
            }
            return 1_500_000;
        }
        if (winningCount == 4) {
            return 50_000;
        }
        return 5_000;
    }
}
