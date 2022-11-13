package lotto.domain;

import java.util.List;

public class Calculator {

    int firstWin = 0;
    int secondWin = 0;
    int thirdWin = 0;
    int fourthWin = 0;
    int fifthWin = 0;

    public void updateResult(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int winningCnt = countCorrectNumbers(lottoNumbers, winningNumbers);
        boolean isBonus = isBonusCorrect(lottoNumbers, bonusNumber);
        // TODO else 예약어 없애기 refactoring!
        if (winningCnt == 6) {
            firstWin++;
        } else if (winningCnt == 5 && isBonus) {
            secondWin++;
        } else if (winningCnt == 5) {
            thirdWin++;
        } else if (winningCnt == 4) {
            fourthWin++;
        } else if (winningCnt == 3) {
            fifthWin++;
        }
    }

    private int countCorrectNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int winningCount = 0;
        for (int number : winningNumbers) {
            if (lottoNumbers.contains(number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    private boolean isBonusCorrect(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}