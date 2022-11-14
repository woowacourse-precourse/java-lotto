package lotto.domain;

import static lotto.advice.ErrorMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;

import java.util.List;
import lotto.advice.DuplicateExcption;
import lotto.advice.LottoNumberExcption;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
