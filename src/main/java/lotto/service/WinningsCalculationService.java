package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.printer.SystemGuidePrinter;

import java.util.List;

public class WinningsCalculationService {

    private final User user;

    private final List<Integer> winningsNumber;

    private final Integer bonusNumber;

    private final int[] winningPrice = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
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

        double revenue = ((double) winningPrice / user.getPaymentAmount()) * 100;
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

        return winningCount;
    }

    private Integer calculateWinningPrice(int winningCount, boolean isSecond) {
        if (winningCount < 3) {
            return 0;
        }

        if (isSecond) {
            winningResult[3]++;
            return winningPrice[3];
        }
        winningResult[winningCount - 3]++;
        return winningPrice[winningCount - 3];
    }

    private boolean isSecond(Lotto lotto, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

}
