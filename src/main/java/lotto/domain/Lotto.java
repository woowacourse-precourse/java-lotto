package lotto.domain;

import lotto.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
