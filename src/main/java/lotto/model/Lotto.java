package lotto.model;

import java.util.List;
import lotto.util.Validator;
import lotto.view.View;

/*
 * 로또의 1개 라인(6개의 숫자)을 의미하는 객체
 */

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (!Validator.isValidSize(numbers)) {
            View.printNotLottoSize();
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!Validator.isValidNumbers(numbers)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (!Validator.isUniqueNumber(numbers)) {
            View.printNotUniqueNumber();
            throw new IllegalArgumentException();
        }
    }

}
