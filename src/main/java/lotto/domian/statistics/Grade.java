package lotto.domian.statistics;

import java.util.List;

public class Grade {

    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Grade(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize returnLottoGrade(List<Integer> lottoNumbers) {
        int correctNumbers = countCorrectNumbers(lottoNumbers);
        if (correctNumbers == FIVE) {
            return checkLottoNumbersContainBonusNumber(lottoNumbers);
        }
        return checkLottoGrade(correctNumbers);
    }

    public Prize checkLottoGrade(int correctNumbers) {
        if (correctNumbers == SIX) {
            return Prize.FIRST;
        }
        if (correctNumbers == FOUR) {
            return Prize.FOURTH;
        }
        if (correctNumbers == THREE) {
            return Prize.FIFTH;
        }
        return null;
    }

    public Prize checkLottoNumbersContainBonusNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

    public int countCorrectNumbers(List<Integer> lottoNumbers) {
        int correctNumbers = ZERO;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                correctNumbers++;
            }
        }
        return correctNumbers;
    }
}
