package lotto.domian.statistics;

import java.util.List;

public class Grade {

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

    public int countCorrectNumbers(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int correctNumbers = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                correctNumbers++;
            }
        }
        return correctNumbers;
    }
}
