package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResultGenerator {
    private final Map<Integer, Integer> winningDetails;
    private double earningRate;

    public LottoGameResultGenerator() {
        winningDetails = new HashMap<>();
        initializeWinningDetails();
    }

    private void initializeWinningDetails() {
        winningDetails.put(5_000, 0);
        winningDetails.put(50_000, 0);
        winningDetails.put(1_500_000, 0);
        winningDetails.put(30_000_000, 0);
        winningDetails.put(2_000_000_000, 0);
    }

    public LottoGameResult generateLottoGameResult(List<Lotto> lottos,
                                                   WinningNumbers winningNumbers,
                                                   int paidMoney) {
        calculateWinningDetails(lottos, winningNumbers);
        calculateEarningRate(paidMoney);

        LottoGameResult lottoGameResult = new LottoGameResult(winningDetails, earningRate);
        return lottoGameResult;
    }

    private void calculateWinningDetails(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            int winningCount = calculateWinningCount(lotto, winningNumbers);
            updateWinningDetails(lotto, winningNumbers, winningCount);
        }
    }

    private int calculateWinningCount(Lotto lotto, WinningNumbers winningNumbers) {
        int winningCount = 0;
        for (int number : winningNumbers.getNumbers()) {
            if (lotto.contains(number)) {
                winningCount += 1;
            }
        }
        return winningCount;
    }

    private void updateWinningDetails(Lotto lotto, WinningNumbers winningNumbers, int winningCount) {
        if (winningCount < 3) {
            return;
        }

        int prizeMoney = getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);
        int oldValue = winningDetails.get(prizeMoney);
        int newValue = oldValue + 1;
        winningDetails.put(prizeMoney, newValue);
    }

    private int getPrizeMoneyByWinningCount(Lotto lotto, WinningNumbers winningNumbers, int winningCount) {
        int bonusNumber = winningNumbers.getBonusNumber();
        if (winningCount == 6) {
            return 2_000_000_000;
        }
        if (winningCount == 4) {
            return 50_000;
        }
        if (winningCount == 3) {
            return 5_000;
        }
        if (lotto.contains(bonusNumber)) {
            return 30_000_000;
        }
        return 1_500_000;
    }

    private void calculateEarningRate(int paidMoney) {
        int profits = calculateProfits();
        earningRate = (profits / (double)paidMoney) * 100;
    }

    private int calculateProfits() {
        int profits = 0;
        for (int prizeMoney : winningDetails.keySet()) {
            profits += prizeMoney * winningDetails.get(prizeMoney);
        }
        return profits;
    }
}
