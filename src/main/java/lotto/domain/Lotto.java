package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final LottoException lottoException = new LottoException();
    private final static int BONUS_INDEX = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void validateNumbers(List<Integer> numbers) {
        lottoException.validateLottoNumbers(numbers);
    }

    public void setBonusNumber(int inputBonusNumber) {
        lottoException.validateBonusNumbers(numbers, inputBonusNumber);
        numbers.add(inputBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return numbers.get(BONUS_INDEX);
    }
}
