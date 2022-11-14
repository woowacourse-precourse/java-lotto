package lotto.domian.statistics;

import java.util.List;

public class Grade {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Grade(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize returnLottoGrade(List<Integer> lottoNumbers) {
        int correctNumbers = countCorrectNumbers(lottoNumbers);
        if (correctNumbers == 5) {
            return checkLottoNumbersContainBonusNumber(lottoNumbers);
        }
        return checkLottoGrade(correctNumbers);
    }

    public Prize checkLottoGrade(int correctNumbers) {
        if (correctNumbers == 6) {
            return Prize.FIRST;
        }
        if (correctNumbers == 4) {
            return Prize.FOURTH;
        }
        if (correctNumbers == 3) {
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
        int correctNumbers = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                correctNumbers++;
            }
        }
        return correctNumbers;
    }
}
