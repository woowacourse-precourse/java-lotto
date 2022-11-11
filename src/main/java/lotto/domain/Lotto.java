package lotto.domain;

import static lotto.util.LottoUtil.bonusNumberParser;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    LottoException lottoException = new LottoException();
    private List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.bonusNumber = 0;
    }

    public void validateNumbers(List<Integer> numbers) {
        lottoException.validateLottoNumbers(numbers);
    }

    public void setBonusNumber(int inputBonusNumber) {
        lottoException.validateBonusNumbers(inputBonusNumber);
        this.bonusNumber = bonusNumberParser(inputBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
