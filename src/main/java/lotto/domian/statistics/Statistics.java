package lotto.domian.statistics;

import java.util.List;

public class Statistics {

    private String checkLottoNumbersContainBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
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
