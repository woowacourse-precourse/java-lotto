package lotto.domian.statistics;

import java.util.List;

public class Grade {

    List<Integer> winningNumbers;

    public Grade(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public String returnLottoGrade(List<Integer> lottoNumbers, int bonusNumber) {
        int correctNumbers = countCorrectNumbers(lottoNumbers);
        if (correctNumbers == 5) {
            return checkLottoNumbersContainBonusNumber(lottoNumbers, bonusNumber);
        }
        return checkLottoGrade(correctNumbers);
    }

    public String checkLottoGrade(int correctNumbers) {
        if (correctNumbers == 6) {
            return "FIRST";
        }
        if (correctNumbers == 4) {
            return "FOURTH";
        }
        if (correctNumbers == 3) {
            return "FIFTH";
        }
        return null;
    }

    public String checkLottoNumbersContainBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return "SECOND";
        }
        return "THIRD";
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
