package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.IntConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue(), IntConstant.LOTTO_NUMBER_COUNT.getValue());
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int[] compareToWinningLotto(WinningLotto winningLotto) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        int[] result = new int[2];
        for (int lottoNum : this.numbers) {
            if (winningLottoNumbers.contains(lottoNum)) {
                result[0] += 1;
            } else if (bonusNumber == lottoNum) {
                result[1] += 1;
            }
        }
        return result;
    }
    // TODO: 추가 기능 구현
}
