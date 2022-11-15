package lotto.compareLottoNumber;

import java.util.List;
import lotto.buyLotto.Lotto;

public class CompareNumber {

    public void increaseArrayValue(int num, List<Lotto> lottoNumbers, int compareLoop, int[] prizeNumbers,
                                   int[] result) {
        for (int correctNumber = 3; correctNumber <= 6; correctNumber++) {
            if (num == 3) {
                num = 4;
            }
            if (lottoNumbers.get(compareLoop).compareNumbers(prizeNumbers) == correctNumber) {
                result[num]++;
            }
            num++;
        }
    }

    public void comparePrizeNumber(int money, int[] result, List<Lotto> lottoNumbers, int[] prizeNumbers) {
        for (int compareLoop = 0; compareLoop < money; compareLoop++) {
            int num = 0;
            increaseArrayValue(num, lottoNumbers, compareLoop, prizeNumbers, result);
        }

    }

    public void comparePrizeNumberWithBonusNumber(int money, int[] result, List<Lotto> lottoNumbers, int[] prizeNumbers,
                                                  int bonusNumber) {
        for (int compareLoop = 0; compareLoop < money; compareLoop++) {
            if (lottoNumbers.get(compareLoop).compareNumberWithBonus(prizeNumbers, bonusNumber) == 6) {
                result[2]--;
                result[3]++;
            }
        }
    }
}
