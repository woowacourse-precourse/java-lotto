package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.printer.SystemGuidePrinter;

import java.util.List;

public class WinningsCalculationService {

    private final User user;

    private final List<Integer> winningsNumber;

    private final Integer bonusNumber;

    private int[] winningResult = new int[5];

    public WinningsCalculationService(User user, List<Integer> winningsNumber, Integer bonusNumber) {
        this.user = user;
        this.winningsNumber = winningsNumber;
        this.bonusNumber = bonusNumber;
    }

    public void winningHistoryCalculation() {
        int winningPrice = 0;
        List<Lotto> lottoList = user.getLottoList();

        for (Lotto lotto : lottoList) {
            winningPrice += calculateWinningNumber(lotto, winningsNumber, bonusNumber);
        }

        int revenue = winningPrice / user.getPaymentAmount() * 100;
        SystemGuidePrinter.winningHistoryMessage(winningResult, revenue);
    }

    private Integer calculateWinningNumber(Lotto lotto, List<Integer> winningsNumbers, Integer bonusNumber) {
        int winningCount = getWinningCount(lotto, winningsNumbers);
        boolean isSecond;

        isSecond = isSecond(lotto, bonusNumber);
        return calculateWinningPrice(winningCount, isSecond);
    }

    private Integer getWinningCount(Lotto lotto, List<Integer> winningsNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int winningCount = 0;

        for (int number: winningsNumbers) {
            if (lottoNumbers.contains(number)) {
                winningCount++;
            }
        }

        if (winningCount < 3) {
            return 0;
        }
        return winningCount;
    }

    private Integer calculateWinningPrice(int winningCount, boolean isSecond) {
        int winningPrice = 0;

        if (winningCount == 3) {
            winningPrice += 5000;
            winningResult[0]++;
        }
        if (winningCount == 4) {
            winningPrice += 50000;
            winningResult[1]++;
        }
        if (winningCount == 5) {
            winningPrice += 1500000;
            winningResult[2]++;
        }
        if (winningCount == 5 && isSecond) {
            winningPrice += 30000000;
            winningResult[3]++;
        }
        if (winningCount == 6) {
            winningPrice += 2000000000;
            winningResult[4]++;
        }

        return winningPrice;
    }

    private boolean isSecond(Lotto lotto, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

}
