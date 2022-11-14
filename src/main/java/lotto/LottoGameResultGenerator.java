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
                                                   BonusNumber bonusNumber,
                                                   Money paidMoney) {
        calculateWinningDetails(lottos, winningNumbers, bonusNumber);
        calculateEarningRate(paidMoney);

        LottoGameResult lottoGameResult = new LottoGameResult(winningDetails, earningRate);
        return lottoGameResult;
    }

    private void calculateWinningDetails(List<Lotto> lottos,
                                                WinningNumbers winningNumbers,
                                                BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            int winningCount = calculateWinningCount(lotto, winningNumbers);
            updateWinningDetails(lotto, bonusNumber, winningCount);
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

    private void updateWinningDetails(Lotto lotto, BonusNumber bonusNumber, int winningCount) {
        if (winningCount < 3) {
            return;
        }

        int prizeMoney = getPrizeMoneyByWinningCount(lotto, bonusNumber, winningCount);
        int oldValue = winningDetails.get(prizeMoney);
        int newValue = oldValue + 1;
        winningDetails.put(prizeMoney, newValue);
    }

    private int getPrizeMoneyByWinningCount(Lotto lotto, BonusNumber bonusNumber, int winningCount) {
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

    private void calculateEarningRate(Money paidMoney) {
        int profits = calculateProfits();
        earningRate = (profits / (double)paidMoney.getMoney()) * 100;
    }

    private int calculateProfits() {
        int profits = 0;
        for (int prizeMoney : winningDetails.keySet()) {
            profits += prizeMoney * winningDetails.get(prizeMoney);
        }
        return profits;
    }
}
