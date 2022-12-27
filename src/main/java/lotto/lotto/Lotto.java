package lotto.lotto;

import lotto.lotto.validation.ValidationLottoNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationLottoNumbers validationLottoNumbers = ValidationLottoNumbers.validate(numbers);
        if (validationLottoNumbers.getIsThrow()) {
            String errorMessage = validationLottoNumbers.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
