package lotto.domain;

import java.util.List;

import lotto.utils.LottoInfo;
import lotto.utils.Validator;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            Validator.listLengthCheck(numbers, LottoInfo.LENGTH.getNumber());
            Validator.containDuplicate(numbers);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}