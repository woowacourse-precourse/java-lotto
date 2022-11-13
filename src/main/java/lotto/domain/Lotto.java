package lotto.domain;

import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumber(numbers);
        this.numbers = new ArrayList<>();
        addLottoNumbers(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void addLottoNumbers(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
