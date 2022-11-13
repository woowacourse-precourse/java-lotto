package lotto.domain;

import lotto.application.util.inputvalidator.InputValidator;
import lotto.application.util.inputvalidator.InputValidatorImpl;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private final InputValidator inputValidator = InputValidatorImpl.getInputValidatorInstance();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        inputValidator.validateInputLottoNumbers(numbers);
    }
}
