package lotto.compareLottoNumber;

import java.util.List;
import lotto.buyLotto.Lotto;

public class CompareNumber {
    public void comparePrizeNumber(int money, int[] result, List<Lotto> lottoNumbers, int[] prizeNumbers) {
        for (int compareLoop = 0; compareLoop < money; compareLoop++) {
            int num = 0;

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
    }
}
