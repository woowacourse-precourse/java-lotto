package lotto.model.Lotto;

import lotto.util.InputLottoValidator;
import lotto.util.NumberFormatValidator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputLottoValidator.validateLottoCount(numbers);
        for (Integer number: numbers) {
            NumberFormatValidator.validateLottoNumberFormat(number);
            InputLottoValidator.validateDuplicateLottoNumber(numbers, number);
        }
    }
}