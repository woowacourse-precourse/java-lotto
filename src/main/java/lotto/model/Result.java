package lotto.model;

import java.util.HashMap;

public class Result {

    private HashMap<Prize, Integer> result = new HashMap<>();

    public Result(LottoTickets lottoTickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        updateLotteryResult(lottoTickets, winningNumbers, bonusNumber);
    }

    public HashMap<Prize, Integer> getResult() {
        return result;
    }

    private void updateLotteryResult(LottoTickets lottoTickets, WinningNumbers winningNumbers,
                                     BonusNumber bonusNumber) {
        for (Lotto lotto : lottoTickets.getTickets()) {
            updateLottoResult(lotto, winningNumbers, bonusNumber);
        }
    }

    private void updateLottoResult(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int winningCnt = countMatchingNumbers(lotto, winningNumbers);
        boolean isBonus = isBonusCorrect(lotto, bonusNumber);
        filterSecondOrThird(winningCnt, isBonus);
        for (Prize e : Prize.values()) {
            result.put(e, result.getOrDefault(e, 0));
            if (e.getWinningCount() == winningCnt && winningCnt != 5) {
                result.put(e, result.get(e) + 1);
            }
        }
    }

    private void filterSecondOrThird(int winningCnt, boolean isBonus) {
        if (winningCnt == 5) {
            if (isBonus) {
                result.put(Prize.SECOND, result.getOrDefault(Prize.SECOND, 0) + 1);
                return;
            }
            result.put(Prize.THIRD, result.getOrDefault(Prize.THIRD, 0) + 1);
        }
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        int winningCount = 0;
        for (int number : winningNumbers.getWinningNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    private boolean isBonusCorrect(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
