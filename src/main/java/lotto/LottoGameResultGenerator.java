package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResultGenerator {
    public static LottoGameResult generateLottoGameResult(List<Lotto> lottos,
                                                          WinningNumbers winningNumbers,
                                                          BonusNumber bonusNumber,
                                                          Money paidMoney) {
        Map<Integer, Integer> winningDetails = new HashMap<>();
        initializeWinningDetails(winningDetails);
        calculateWinningDetails(winningDetails, lottos, winningNumbers, bonusNumber);
        double earningRate = calculateEarningRate(winningDetails, paidMoney);

        LottoGameResult lottoGameResult = new LottoGameResult(winningDetails, earningRate);
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
            // winningCount세는 것도 update안에 넣는 게 어떨지?
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
        // if를 6 5 4 3 순으로 하지 말고 6 4 3 보너스확인 이렇게 하면 지금처럼 if 두개 중첩되는 걸 뺄 수 있음
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

    private static double calculateEarningRate(Map<Integer, Integer> winningDetails, Money paidMoney) {
        int profits = calculateProfits(winningDetails);
        double earningRate = (profits / (double)paidMoney.getMoney()) * 100;
        return earningRate;
    }

    private static int calculateProfits(Map<Integer, Integer> winningDetails) {
        int profits = 0;
        for (int prizeMoney : winningDetails.keySet()) {
            profits += prizeMoney * winningDetails.get(prizeMoney);
        }
        return profits;
    }
}
