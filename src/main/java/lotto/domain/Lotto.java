package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final LottoException lottoException = new LottoException();
    private final static int BONUS_INDEX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValidNumber(numbers);
        this.numbers = numbers;
    }

    public void isValidNumber(List<Integer> numbers) {
        lottoException.isValidLottoNumbers(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        lottoException.isValidBonusNumber(numbers, bonusNumber);
        numbers.add(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return numbers.get(BONUS_INDEX);
    }
}
